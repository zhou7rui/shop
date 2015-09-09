package com.dzwz.shop.service;

import com.dzwz.shop.model.Forder;
import com.dzwz.shop.model.Product;
import com.dzwz.shop.model.Sorder;

public interface SorderService extends BaseService<Sorder> {
	
		public Forder addSorder(Forder forder, Product product);
		
		public Sorder productToSorder(Product product);
	
}
