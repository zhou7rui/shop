package com.dzwz.shop.action;

import com.dzwz.shop.model.Forder;
import com.dzwz.shop.model.SendData;
import com.dzwz.shop.model.User;

public class PayAction extends BaseAction<SendData> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7061630353212938617L;

	public String goBank(){
		//1.补全参数   p2 p3 pd pa 从session中获取
		Forder forder = (Forder)session.get("oldForder"); 
		User user = (User)session.get("userInfo");
		model.setP2_Order(forder.getId().toString());
		model.setP3_Amt(forder.getPrice().toString());
		model.setPa_MP(user.getPhone()+user.getEmail());
		return "";
	}
	
}
