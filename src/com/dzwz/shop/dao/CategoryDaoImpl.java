package com.dzwz.shop.dao;

import java.util.List;

import com.dzwz.shop.model.Category;

@SuppressWarnings("unchecked")
public class CategoryDaoImpl extends BaseDaoIpml<Category> implements CategoryDao {

	
	@Override
	public List<Category> QueryJoinUser(String type, int page, int size) {
			
		return getSession().createQuery("FROM Category c LEFT JOIN FETCH c.user WHERE c.type like :type")
				.setString("type", "%"+type+"%")
				.setFirstResult((page-1)*size)
				.setMaxResults(size)
				.list();
	}
}
