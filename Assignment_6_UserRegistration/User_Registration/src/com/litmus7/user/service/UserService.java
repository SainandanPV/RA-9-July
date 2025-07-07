package com.litmus7.user.service;

import java.sql.SQLException;

import com.litmus7.user.dao.UserDao;
import com.litmus7.user.dto.User;
import com.litmus7.user.exception.*;

public class UserService {
	private UserDao userDao=new UserDao();
	
	public User registerUser(String username,int age,String email,String password) throws InvalidAgeException,InvalidEmailException,DuplicateUsernameException,SQLException, Exception,WeakPasswordException{
		if(username==null||username.trim().isEmpty()) {
			throw new Exception("Username can't be empty..");
		}
		if(age<18||age>60) {
			throw new InvalidAgeException("Age should be between 18 and 60!!");
		}
		if(!email.contains("@")||!email.contains(".")) {
			throw new InvalidEmailException("Invalid Email Address..");
		}
		if(password.length()<6) {
			throw new WeakPasswordException("Password length must be greater than 6!");
		}
		if(userDao.usernameExists(username)) {
			throw new DuplicateUsernameException("Username already exists!!");
		}
		User user=new User(username,age,email,password);
		userDao.saveUser(user);
		return user;
	}
	
	
}
