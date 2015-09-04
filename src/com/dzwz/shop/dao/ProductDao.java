package com.dzwz.shop.dao;

import java.util.List;


import com.dzwz.shop.model.Product;

public interface ProductDao extends BaseDao<Product>{
	//分页查询
	public List<Product>  QueryJoinProduct(String name, int page, int size);
	//查询总数
	public Integer totalCategory(String name);
	
	//根据ids删除
	public void deleteByids(String ids);
}
