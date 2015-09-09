package com.dzwz.shop.action;

import java.util.HashSet;


import com.dzwz.shop.model.Forder;
import com.dzwz.shop.model.Product;
import com.dzwz.shop.model.Sorder;



public class SorderAction extends BaseAction<Sorder> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
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
	

}
