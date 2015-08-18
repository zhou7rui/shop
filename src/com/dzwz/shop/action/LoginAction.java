package com.dzwz.shop.action;

import com.dzwz.shop.model.User;
import com.dzwz.shop.service.UserServiceImpl;


public class LoginAction extends BaseAction<User>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UserServiceImpl   userService;
	
	public void setUserService(UserServiceImpl userService) {
		this.userService = userService;
	}
	
	public String  Login() {
		if(userService.login(model).equals("success")){
				session.put("userinif", model);
				return SUCCESS;
		}else{
			return "login";
		}	
	} 


}
