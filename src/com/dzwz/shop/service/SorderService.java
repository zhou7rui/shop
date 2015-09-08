package com.dzwz.shop.service;

import com.dzwz.shop.model.Forder;
import com.dzwz.shop.model.Sorder;




public interface SorderService extends BaseService<Sorder> {
	
		public Double totalPrice(Forder forder);
	
}
