package com.dzwz.shop.service;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import com.dzwz.shop.dao.BaseDao;

public class BaseServiceImpl<T> implements BaseService<T>{

   private Class<T> clazz;
   
   public BaseServiceImpl(){
	   
	   ParameterizedType  type =   (ParameterizedType) this.getClass().getGenericSuperclass();
	   clazz = clazz = (Class<T>) type.getActualTypeArguments()[0];
   }
 
	
   public BaseDao<T> baseDao;
   
   public void setBaseDao(BaseDao baseDao) {
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
	public void delete(Integer id) {
		baseDao.delete(id);
	}

	@Override
	public T queryByid(Integer id) {
		return (T) baseDao.queryByid(id);
	}

	@Override
	public List<T> query() {
		return baseDao.query();
	}
    


	


	
	

}
