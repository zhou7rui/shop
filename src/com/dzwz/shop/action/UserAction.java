package com.dzwz.shop.action;

import java.util.ArrayList;
import java.util.List;

import com.dzwz.shop.model.User;

public class UserAction extends BaseAction<User> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * 用户查询
	 * @author zrui
	 * @time 2015年9月2日15:12:17
	 * @version v.0.1
	 */
	public String queryUser(){
		jsonList =userService.query();
		return "jsonlist";
	}
	
	public String login(){
		//进行登录的判断
	    User  user= userService.login(model);
	    if(user!=null){
	    	session.put("userInfo", user);
	    	if(session.get("goURL")==null){
	    		return "index";
	    	}else{
	    		return "goURL";
	    	}
	    }else{
	    	request.put("error", "登录失败");
	    	return "loginFa";
	    }
	}
	
}
