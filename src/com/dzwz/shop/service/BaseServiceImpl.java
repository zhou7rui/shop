package com.dzwz.shop.service;


import java.util.List;

import com.dzwz.shop.dao.BaseDao;

public class BaseServiceImpl<T> implements BaseService<T>{


 
	
   public BaseDao<T> baseDao;
   
   public void setBaseDao(BaseDao<T> baseDao) {
	this.baseDao = baseDao;
   }
	
	@Override
	public void save(T t) {
		baseDao.save(t);
		
	}

	@Override
	public void update(T t) {
		baseDao.update(t);
	}

	@Override
	public void delete(int id) {
		baseDao.delete(id);
	}

	@Override
	public T queryByid(int id) {
		return (T) baseDao.queryByid(id);
	}

	@Override
	public List<T> query() {
		return baseDao.query();
	}
    


	


	
	

}
