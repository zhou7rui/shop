package com.dzwz.shop.dao;

import java.util.List;

import com.dzwz.shop.model.Category;


public interface CategoryDao extends BaseDao<Category> {
	
	public List<Category>  QueryJoinUser(String type, int page, int size);
	

}
