package com.litmus7.rental;

import java.util.Scanner;

public class VehicleApp{
	
	public static void main(String args[]) {
		
		Scanner scanner=new Scanner(System.in);
		
		//Using parameterized Constructor
		Car car1=new Car("Honda","Civic",1400.0,4,false);
		System.out.println("---- Displaying Car Details (Parameterized) ----");
		car1.displayDetails();
		
		// Using default constructor for Car
        System.out.println("--- Enter Car Details (Default Constructor + User Input) ---");
        Car car2 = new Car();
        car2.inputDetails();
        System.out.println("--- Displaying Car Details (Default Constructor + User Input) ---");
        car2.displayDetails();
        
        // Parameterized Bike
        System.out.println("\n--- Displaying Bike Details (Parameterized) ---");
        Bike bike1 = new Bike("Suzuki","Gixxer",600.0,false,125);
        bike1.displayDetails();
        
        // Using default constructor+input for Bike
        System.out.println("--- Enter Bike Details (Default Constructor + User Input) ---");
        Bike bike2=new Bike();
        bike2.inputDetails();
        System.out.println("--- Displaying Bike Details (Default Constructor + User Input) ---");
        bike2.displayDetails();
        
        scanner.close();
	}
}