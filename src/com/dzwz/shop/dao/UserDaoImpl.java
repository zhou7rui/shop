package com.dzwz.shop.dao;

import org.hibernate.Criteria;

import com.dzwz.shop.model.User;

public class UserDaoImpl<Uset> extends BaseDaoIpml<User> implements UserDao {

	@Override
	public User QueryUser(User user) {
		Criteria criteria = getSession().createCriteria(User.class);
		
		return (User) criteria.uniqueResult();
	}

	
	

}
