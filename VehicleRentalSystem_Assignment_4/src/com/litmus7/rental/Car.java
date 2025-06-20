package com.litmus7.rental;
import java.util.Scanner;

public class Car extends Vehicle{
	private int numberOfDoors;
	private boolean isAutomatic;
	
	//Default Constructor
	public Car() {
		super();
		numberOfDoors=4;
		isAutomatic=false;
	}
	
	//Parameterized Constructor
	public Car(String brand, String model, double rentalPricePerDay, int numberOfDoors, boolean isAutomatic) {
	    super(brand, model, rentalPricePerDay); // initialize Vehicle fields
	    this.numberOfDoors = numberOfDoors;     // initialize Car fields
	    this.isAutomatic = isAutomatic;
	}
	Scanner scanner=new Scanner(System.in);
	@Override
	public void inputDetails() {
		super.inputDetails();
		
		System.out.println("Enter Number of doors : ");
		numberOfDoors=scanner.nextInt();
		System.out.println("The car is automatic : True or False ?  ");
		isAutomatic=scanner.nextBoolean();
	}
	
	@Override
	public void displayDetails() {
		super.displayDetails();
		System.out.println("Number of doors : " + numberOfDoors);
	    if(isAutomatic) {
	    	System.out.println("Car is Automatic");
	    }
	    else System.out.println("Car is Manual");
	}
	
}