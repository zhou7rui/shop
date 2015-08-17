package com.dzwz.shop.service;

import java.util.List;

public interface BaseService<T> {
	public void save(T t);
	public void update(T t);
	public void delete(T t);
	public T queryByid(Integer id);
	public List<T> query(T t);
}
