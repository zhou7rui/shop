package com.dzwz.shop.dao;

import java.util.List;

import com.dzwz.shop.model.Category;


public interface CategoryDao extends BaseDao<Category> {
	
	//分页查询
	public List<Category>  QueryJoinUser(String type, int page, int size);
	//查询总数
	public Integer totalCategory(String type);
	
	//根据ids删除
	public void deleteByids(String ids);

}
