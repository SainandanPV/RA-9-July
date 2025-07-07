package com.litmus7.user.controller;

import com.litmus7.user.dto.User;
import com.litmus7.user.service.UserService;

public class UserController {
	private UserService userService=new UserService();
	public User register(String username,int age, String email,String password) throws Exception {
		return userService.registerUser(username, age, email, password);
	}	
}
