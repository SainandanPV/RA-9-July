package com.litmus7.user.ui;

import java.util.Scanner;

import com.litmus7.user.controller.UserController;
import com.litmus7.user.dto.User;

public class RegistrationApp {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		UserController userController=new UserController();
		System.out.println("Welcome to User registration system");
		try {
			System.out.println("Enter username : ");
			String username=scanner.nextLine();
			System.out.println("Enter age : ");
			int age=Integer.parseInt(scanner.nextLine());
			System.out.println("Enter email : ");
			String email=scanner.nextLine();
            System.out.print("Enter password : ");
            String password = scanner.nextLine();
            
            User user = userController.register(username, age, email, password);
            
            System.out.println("Registration successful!!");
            System.out.println("User Details : ");
            user.displayDetails();
		}
		catch(Exception e) {
			System.out.println("Error : "+e.getMessage());
		}
		scanner.close();
		
	}
}
