package com.litmus7.rental.dto;

public class Vehicle {
	private String brand;
	private String model;
	private double rentalPricePerDay;
	private boolean isRented=false;
		
	//default constructor
	public Vehicle() {
		this.brand="";
		this.model="";
		this.rentalPricePerDay=0.0;
	}
	
	//parameterized constructor
	public Vehicle(String brand, String model, double rentalPricePerDay) {
        this.brand = brand;
        this.model = model;
        this.rentalPricePerDay = rentalPricePerDay;
        
	}
	
	public void displayDetails() {
        System.out.println("Brand : " + brand);
        System.out.println("Model : " + model);
        System.out.println("Rental price per day : " + rentalPricePerDay);
        System.out.println("Is Rented : " + isRented);
    }
	
	//Getters 
	public String getBrand() { 
		return brand; 
	}
    public String getModel() { 
    	return model; 
    }
    public double getRentalPricePerDay() { 
    	return rentalPricePerDay; 
    }
    public boolean isRented() { 
    	return isRented; 
    }
    public void rent() { 
    	isRented = true; 
    }
    public void returnVehicle() { 
    	isRented = false; 
    }
    
}
