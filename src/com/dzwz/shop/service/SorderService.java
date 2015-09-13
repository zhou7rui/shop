package com.dzwz.shop.service;

import com.dzwz.shop.model.Forder;
import com.dzwz.shop.model.Product;
import com.dzwz.shop.model.Sorder;

public interface SorderService extends BaseService<Sorder> {
		
	    /**
	     * 添加商品到购物车
	     * @param forder
	     * @param product
	     * @return
	     */
		public Forder addSorder(Forder forder, Product product);
		/**
		 * 将得到的商品信息放进购物项
		 * @param product
		 * @return
		 */
		public Sorder productToSorder(Product product);
		
		/**
		 * 
		 * 更新商品信息
		 * @param forder
		 * @param product
		 * @return
		 */
		public Forder upadteSorder(Forder forder, Sorder sorder);
	
}
