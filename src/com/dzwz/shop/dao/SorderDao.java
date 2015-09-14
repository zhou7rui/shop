package com.dzwz.shop.dao;

import java.util.List;

import com.dzwz.shop.model.Sorder;

public interface SorderDao extends BaseDao<Sorder> {
	
	/**
	 * 
	 * 查询销售额
	 * @param number
	 * @return
	 */
	public List<Object> querySale(int number);
	
}
