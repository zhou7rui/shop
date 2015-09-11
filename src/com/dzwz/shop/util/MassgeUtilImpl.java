package com.dzwz.shop.util;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.stereotype.Component;

/**
 * 服务信息发送工具类
 * 
 * @param args
 */
@Component("massgeUtil")
public class MassgeUtilImpl implements MassageUtil {
	
	
	/* (non-Javadoc)
	 * @see com.dzwz.shop.util.MassageUtil#sendEmail(int, java.lang.String)
	 */
	@Override
	public void sendEmail(int id,String Email) {
		Transport transport= null;
		Properties prop =null;
		Session session =null;
	try {
		//登录邮件客户端
	    prop = new Properties();
		prop.setProperty("mail.transport.protocol", "smtp");
		//创建session 会话
		session = Session.getDefaultInstance(prop);
		session.setDebug(true);
		//创建邮件对象
		Message message = new  MimeMessage(session);
		//****************写信******************************
			//主题
			message.setSubject("订单支付成功邮件！！");
			//正文
			message.setContent("订单"+id+"已经支付成功", "text/html;charset=utf-8");
			//发件人地址
			message.setFrom(new InternetAddress("soft03_test@sina.com"));
			//设置收件人地址 和连接服务器的认证信息
		    transport = session.getTransport();
			//设置连接服务器的认证信息
			transport.connect("smtp.sina.com", "soft03_test", "soft03_test");
			//设置收件人地址
			transport.sendMessage(message, new Address[]{new InternetAddress(Email)});
		} catch (MessagingException e) {
			e.printStackTrace();
		}finally{
			try {
				transport.close();
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}
	
	}
	
	
	/* (non-Javadoc)
	 * @see com.dzwz.shop.util.MassageUtil#sendmessage(java.lang.String, java.lang.String)
	 */
		
		@Override
		public void  sendmessage(String phone,int id){
			//状态码
			int statusCode = 0;
			HttpClient client = new HttpClient();
			PostMethod post = new PostMethod("http://utf8.sms.webchinese.cn"); 
			//设置传递参数
			post.addParameter("Content-Type","application/x-www-form-urlencoded;charset=gbk");//在头文件中设置转码
			post.setParameter("Uid", "a_shop_test");
			post.setParameter("Key", "577a28bdaec8c5efa3c5");
			post.setParameter("smsMob", phone);
			post.setParameter("smsText", "你的"+id+"订单已经支付成功,感谢你在本商城的购物,祝你生活愉快");
			try {
				//提交请求
				statusCode = client.executeMethod(post);
				System.out.println("statusCode:"+statusCode);
				//获取服务器换回信息
				String result = post.getResponseBodyAsString();
				System.out.println("短息发送结果信息："+result);
				
			} catch (HttpException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
			post.releaseConnection();
			}
			}
		public static void main(String[] args) {
			//状态码
			int statusCode = 0;
			HttpClient client = new HttpClient();
			PostMethod post = new PostMethod("http://utf8.sms.webchinese.cn"); 
			//设置传递参数
			post.addParameter("Content-Type","application/x-www-form-urlencoded;charset=gbk");//在头文件中设置转码
			post.setParameter("Uid", "a_shop_test");
			post.setParameter("Key", "577a28bdaec8c5efa3c5");
			post.setParameter("smsMob", "13101008846");
			post.setParameter("smsText", "你的"+123+"订单已经支付成功,感谢你在本商城的购物,祝你生活愉快");
			try {
				//提交请求
				statusCode = client.executeMethod(post);
				System.out.println("statusCode:"+statusCode);
				//获取服务器换回信息
				String result = post.getResponseBodyAsString();
				System.out.println("短息发送结果信息："+result);
				
			} catch (HttpException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
			post.releaseConnection();
			}
		}
}
