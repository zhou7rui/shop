package com.dzwz.shop.service;


import com.dzwz.shop.model.Forder;
import com.dzwz.shop.model.Sorder;


public class SorderServiceImpl extends BaseServiceImpl<Sorder> implements
		SorderService {

	/**
	 * 计算出总价格
	 * 
	 * @author zrui
	 * @time 2015年9月8日16:51:12
	 * @vserion v.0.1
	 * 
	 */
	
	@Override
	public Double totalPrice(Forder forder) {
		Double totalPrice = 0.0;
		for(Sorder sorder : forder.getSorders() ){
			totalPrice +=sorder.getPrice()*sorder.getNumber();
		}
		return totalPrice;
	}
	
}
