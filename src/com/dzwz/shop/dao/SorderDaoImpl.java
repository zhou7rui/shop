package com.dzwz.shop.dao;

import java.util.List;

import com.dzwz.shop.model.Sorder;

@SuppressWarnings("unchecked")
public class SorderDaoImpl extends BaseDaoIpml<Sorder> implements SorderDao {
	
	/**
	 * 查询销售额
	 * 
	 */
	@Override
	public List<Object> querySale(int number) {
		String hql = "SELECT  s.name, sum(s.number)  FROM Sorder s JOIN s.product GROUP BY s.product.id";
		return getSession()			//
				.createQuery(hql)   //
				.setFirstResult(0)  // 
				.setMaxResults(number)    //
				.list();       //
	}

	

}
