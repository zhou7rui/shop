package com.dzwz.shop.service;

import com.dzwz.shop.model.User;

public interface UserService extends BaseService<User>{
	public String login(User user);
}
