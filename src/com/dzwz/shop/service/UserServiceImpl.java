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
	public String login(User user){
		
		User use1 = userDao.QueryUser(user);
		//检查用户是否存在
		if(use1!=null){	
			//登录校验
			if(use1.getUserName().equals(user.getUserName())
					&&use1.getPwd().equals((user.getPwd()))){
				return "success";
			}else{
				return "failure";
			}
		}
		return "failure";
	}

	
}
