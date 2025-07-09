package com.litmus7.retail.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;

public class DBUtil {
	private static String url;
	private static String username;
	private static String password;
	private static String driverClassName;
	
	static {
		try(InputStream input=DBUtil.class.getClassLoader().getResourceAsStream("db.properties")){
			if(input==null) {
				throw new RuntimeException("Unable to find db.properties!");
			}
			Properties properties=new Properties();
			properties.load(input);
			
			url=properties.getProperty("jdbc.url");
			username = properties.getProperty("jdbc.username");
			password = properties.getProperty("jdbc.password");
			driverClassName = properties.getProperty("jdbc.driverClassName");
			
			Class.forName(driverClassName);
		}
		catch(Exception e) {
			throw new RuntimeException("Failed to load the DB Configuration file",e);
		}
	}
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url,username,password);
	}
}
