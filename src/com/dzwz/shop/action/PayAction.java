package com.dzwz.shop.action;

import java.util.Map;


import org.apache.struts2.interceptor.ParameterAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.dzwz.shop.model.BackData;
import com.dzwz.shop.model.Forder;
import com.dzwz.shop.model.SendData;
import com.dzwz.shop.model.User;


public class PayAction extends BaseAction<Object> implements ParameterAware{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7061630353212938617L;
	private Map<String, String[]> parameters;
	
	@Override
	public void setParameters(Map<String, String[]> parameters) {
		this.parameters = parameters;
	}
	
	
	@Override
	public Object getModel() {
		if(parameters.get("pd_FrpId")!=null){
			model = new SendData();
		}else{
			model = new BackData();
		}
		return model;
	}
	
	public String goBank(){
		//1.补全参数   p2 p3 pd pa 从session中获取
		Forder forder = (Forder)session.get("oldForder"); 
		User user = (User)session.get("userInfo");
		SendData sendData = (SendData) model;
		sendData.setP2_Order(forder.getId().toString());
		sendData.setP3_Amt(forder.getPrice().toString());
		sendData.setPa_MP(user.getPhone()+user.getEmail());
		//对参数追加 加密获取签名   存储到request 中
		payService.saveDataToRequest(request, sendData);
		return "pay";
	}
	
	
	public void backpay(){
		BackData backData = (BackData) model;
	    boolean isOk =	payService.checkBackData(backData);
	    if(isOk){
	    	System.out.println("-------sessucc-------");
	    }
	    else{
	    	System.out.println("---------失败------------");
	    }
	}
	
	
}
