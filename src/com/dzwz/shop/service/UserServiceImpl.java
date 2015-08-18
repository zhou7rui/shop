package com.dzwz.shop.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dzwz.shop.dao.UserDao;
import com.dzwz.shop.model.User;

public class UserServiceImpl {
	

	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public String login(User user){
		
		User use1 = userDao.QueryUser(user);
		if(use1.getUserName().equals(user.getUserName())
				&&use1.getPwd().equals((user.getPwd()))){
			return "success";
		}else{
			return "failure";
		}
	}

}
