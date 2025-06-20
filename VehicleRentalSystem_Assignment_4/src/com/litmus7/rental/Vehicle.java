package com.litmus7.rental;
import java.util.Scanner;


public class Vehicle{
	private String brand;
	private String model;
	private double rentalPricePerDay;
	
	//Default Constructor
	public Vehicle() {
		this.brand="Honda";
		this.model="Civic";
		this.rentalPricePerDay=1400.0;
	}
	
	//Parameterized Constructor
	public Vehicle(String brand, String model, double rentalPricePerDay) {
		this.brand = brand;
		this.model = model;
		this.rentalPricePerDay = rentalPricePerDay;
	}
	Scanner scanner=new Scanner(System.in);
	//Public method to input details
	public void inputDetails() {
		
		System.out.println("Enter the Brand name : ");
		brand=scanner.nextLine();
		System.out.println("Enter the Model name : ");
		model=scanner.nextLine();
		System.out.println("Enter the Rent per day : ");
		rentalPricePerDay=scanner.nextDouble();
	}
	
	//Method to display Vehicle details
	public void displayDetails() {
		System.out.println("Brand: " + brand);
	    System.out.println("Model: " + model);
	    System.out.println("Rental Price per Day: " + rentalPricePerDay);
	}
}


