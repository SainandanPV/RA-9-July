package com.litmus7.rental.dto;

public class Car extends Vehicle {
	private int numberOfDoors;
    private boolean isAutomatic;
    
    //default constructor
    public Car() {
    	super();
    	this.numberOfDoors = 4;
        this.isAutomatic = false;
    }

    //parameterized constructor
    public Car(String brand, String model, double rentalPricePerDay, int numberOfDoors, boolean isAutomatic) {
        super(brand, model, rentalPricePerDay);
        this.numberOfDoors = numberOfDoors;
        this.isAutomatic = isAutomatic;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Number of doors: " + numberOfDoors);
        System.out.println("Car is automatic : " + isAutomatic+"\n");
    }
}
