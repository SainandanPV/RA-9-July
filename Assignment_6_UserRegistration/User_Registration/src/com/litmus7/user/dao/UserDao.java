package com.litmus7.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.litmus7.user.dto.User;
import com.litmus7.user.util.DBConnection;

public class UserDao {
	public boolean usernameExists(String username) throws SQLException{
		String sql="select username from users where username=?";
		try (Connection myConn=DBConnection.getConnection();
			PreparedStatement ps=myConn.prepareStatement(sql)){
			ps.setString(1, username);
			ResultSet myRs=ps.executeQuery();
			return myRs.next();
		}
	}
	
	public void saveUser(User user) throws SQLException{
		String sql="insert into users(username,age,email,password) values(?,?,?,?)";
		try(Connection myConn=DBConnection.getConnection();
			PreparedStatement ps=myConn.prepareStatement(sql)){
			ps.setString(1, user.getUsername());
			ps.setInt(2, user.getAge());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPassword());
			ps.executeUpdate();	
		}
	}
}
