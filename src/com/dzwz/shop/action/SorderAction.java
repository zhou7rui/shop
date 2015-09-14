package com.dzwz.shop.action;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.List;

import com.dzwz.shop.model.Forder;
import com.dzwz.shop.model.Product;
import com.dzwz.shop.model.Sorder;
import com.opensymphony.xwork2.ActionContext;



public class SorderAction extends BaseAction<Sorder> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 *  将商品信息放进购物车中
	 * @return
	 */
	public String addsorder(){
		//1.根据product.id 获取 商品信息
		Product product =	productService.queryByid( model.getProduct().getId());
		
		//2.判断当前购物车是否存在,，没有则创建一个
		if(session.get("forder")==null){
			session.put("forder", new Forder(new HashSet<>()));
		}
		Forder forder  = (Forder) session.get("forder");
		//3.将得到的商品信息放进购物项
		forder = sorderService.addSorder(forder, product);
		//计算总价格
		forder.setPrice(forderService.totalPrice(forder));
		session.put("forder", forder);
		
		return "showCar";
		
	}
	
	//根据id更新数量和价格
	public String updatesorder() throws UnsupportedEncodingException{
		Forder forder = (Forder) session.get("forder");
		forder = sorderService.upadteSorder(forder, model);
		forder.setPrice(forderService.totalPrice(forder));
		session.put("forder", forder);
		//返回流格式
		inputStream = new ByteArrayInputStream(forder.getPrice().toString().getBytes("utf-8"));
		return "stream";
	}
	
	public String querySale(){
		List<Object> jsonList = sorderService.querySale(model.getNumber());
		//将对象压入值栈栈顶
		ActionContext.getContext().getValueStack().push(jsonList);
		return "jsonList";
	}
	
}
