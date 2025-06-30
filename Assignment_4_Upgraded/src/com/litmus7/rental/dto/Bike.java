package com.litmus7.rental.dto;

public class Bike extends Vehicle {
	private boolean hasGear;
    private int engineCapacity;

    //default constructor
    public Bike() {
    	super();
    	this.hasGear = false;
        this.engineCapacity = 125;
    }

    //parameterized constructor
    public Bike(String brand, String model, double rentalPricePerDay, boolean hasGear, int engineCapacity) {
        super(brand, model, rentalPricePerDay);
        this.hasGear = hasGear;
        this.engineCapacity = engineCapacity;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Has Gear : " + hasGear);
        System.out.println("Engine Capacity : " + engineCapacity + "cc"+"\n");
    }
    

}
