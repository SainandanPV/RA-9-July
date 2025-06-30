package com.litmus7.rental.controller;

import java.util.List;

import com.litmus7.rental.dto.Bike;
import com.litmus7.rental.dto.Car;
import com.litmus7.rental.dto.Response;
import com.litmus7.rental.dto.Vehicle;
import com.litmus7.rental.exception.*;
import com.litmus7.rental.service.VehicleService;

public class VehicleController {

    private VehicleService service;
    private final int SUCCESS_STATUS_CODE=200;
    private final int ERROR_STATUS_CODE=500;

    // Default constructor 
    public VehicleController() {
        this.service = new VehicleService();
    }
    
    public VehicleController(VehicleService service) {
        this.service = service;
    }

    // Loads vehicle data from the file
    public Response loadVehiclesFromFile(String filepath) {
    	Response response=new Response();
        try {
        	List<Vehicle> loadedVehicles=service.loadVehicles(filepath);
        	response.setStatusCode(SUCCESS_STATUS_CODE);
        	response.setVehicles(loadedVehicles);
        }
        catch(VehicleServiceException e) {
        	response.setStatusCode(ERROR_STATUS_CODE);
        	response.setErrorMessage(e.getMessage());
        }
        return response;
    }

    // adds vehicle (generic method)
    public void addVehicle(Vehicle vehicle) {
        service.addVehicle(vehicle);
    }

    // returns all the vehicles
    public List<Vehicle> getAllVehicles() {
        return service.getVehicles();
    }

    // returns only available vehicles
    public List<Vehicle> getAvailableVehicles() {
        return service.getAvailableVehicles();
    }

    // Adds a car using parameters (from user input)
    public void addCar(String brand, String model, double price, int doors, boolean isAuto) {
        Vehicle car = new Car(brand, model, price, doors, isAuto);
        service.addVehicle(car);
        
    }

    // Adds a bike using parameters (from user input)
    public void addBike(String brand, String model, double price, boolean hasGear, int capacity) {
        Vehicle bike = new Bike(brand, model, price, hasGear, capacity);
        service.addVehicle(bike);
    }

    // Rents a vehicle by calling the service method
    public void rentVehicle(String brand, String model) throws VehicleServiceException {
        service.rentVehicle(brand, model); 
    }

    // Returns a rented vehicle
    public void returnVehicle(String brand, String model) throws VehicleServiceException {
        service.returnVehicle(brand, model);  
    }

    // Calculates revenue from rented vehicles
    public double calculateRevenue() {
        return service.calculateTotalRentalPriceForRentedVehicles();
    }
}
