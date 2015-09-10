package com.dzwz.shop.service;

import com.dzwz.shop.model.User;

public interface UserService extends BaseService<User>{
	public User login(User user);
}
