package com.dzwz.shop.service;





import com.dzwz.shop.dao.BaseDao;
import com.dzwz.shop.dao.UserDao;
import com.dzwz.shop.model.Category;
import com.dzwz.shop.model.User;

public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{
	

	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	
	public void setBaseDao(BaseDao<User> baseDao) {
		this.baseDao = baseDao;
	   }
	
	public User login(User user){
		
		 userDao.QueryUser(user);
		
		
		return userDao.QueryUser(user);
	}

	
}
