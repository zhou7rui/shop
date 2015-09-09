package com.dzwz.shop.service;

import com.dzwz.shop.model.Forder;
import com.dzwz.shop.model.Sorder;

public interface ForderService extends BaseService<Forder> {
	
		public Double totalPrice(Forder forder);
	
}
