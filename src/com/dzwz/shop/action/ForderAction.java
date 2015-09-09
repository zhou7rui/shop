package com.dzwz.shop.action;

import com.dzwz.shop.model.Status;
import com.dzwz.shop.model.User;
import com.dzwz.shop.model.Forder;



public class ForderAction extends BaseAction<Forder> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	
		//重写getModel从session中的的到 装配好的 购物车
		@Override
		public Forder getModel() {
			model = (Forder) session.get("forder");
			return model;
		}
	
	/**
	 * 实现订单项和购物车的级联入库
	 * 
	 */
	public String save(){
		/*Forder forder  = (Forder) session.get("forder");
		model.setSorders(forder.getSorders());
		model.setPrice(forder.getPrice());
		model.setUser((User)session.get("userInof"));
		//建立与购物项的关联
		forderService.save(model);*/
		model.setUser((User)session.get("userInfo"));
		model.setStatus(new Status(1));
		forderService.save(model);
		return "bank";
	}


}
