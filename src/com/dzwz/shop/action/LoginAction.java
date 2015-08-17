package com.dzwz.shop.action;

import com.dzwz.shop.model.User;

public class LoginAction extends BaseAction<User>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public String  Login() {
		if(model.getUserName().equals("admin")
				&&model.getPwd().equals("123")){
				session.put("userinif", model);
				return SUCCESS;
		}else{
			return "login";
		}	
	} 
	
	

}
