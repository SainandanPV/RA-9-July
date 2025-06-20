package com.litmus7.rental;
import java.util.Scanner;

public class Bike extends Vehicle{
	private int engineCapacity;
	private boolean hasGear;
	
	//Default Constructor
	public Bike() {
		super();
		hasGear=false;
		engineCapacity=125;
	}
	
	//Parameterized Constructor
	public Bike(String brand, String model, double rentalPricePerDay, boolean hasGear, int engineCapacity) {
	    super(brand, model, rentalPricePerDay); // initialize Vehicle fields
	    this.hasGear = hasGear;
	    this.engineCapacity = engineCapacity;     // initialize Bike fields
	    
	}
	Scanner scanner=new Scanner(System.in);
	@Override
	public void inputDetails() {
		super.inputDetails();
		
		System.out.println("Is it geared? : (True or False)  ");
		hasGear=scanner.nextBoolean();
		System.out.println("Enter the Engine Capacity : ");
		engineCapacity=scanner.nextInt();
	}
	
	@Override
	public void displayDetails() {
		super.displayDetails();
	    if(hasGear) {
	    	System.out.println("Bike is geared");
	    }
	    else System.out.println("Bike is gearless");

		System.out.println("Engine Capacity : " + engineCapacity);
	}
}