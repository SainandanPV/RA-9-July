package com.litmus7.rental.service;
import java.util.ArrayList;
import java.util.List;
import com.litmus7.rental.dao.VehicleDAO;
import com.litmus7.rental.dto.Vehicle;
import com.litmus7.rental.exception.*;


public class VehicleService {
	private List<Vehicle> vehicles;
	private VehicleDAO dao;
	public VehicleService() {
		this.vehicles=new ArrayList<>();
		this.dao=new VehicleDAO();
	}
	
	public List<Vehicle> loadVehicles(String filepath) throws VehicleServiceException {
		try{
			List<Vehicle> loaded=dao.loadVehiclesFromFile(filepath);
			vehicles.addAll(loaded);
			return loaded;
		}
		catch(VehicleDataAccessException e) {
			throw new VehicleServiceException("Failed to load vehicles!!",e);
		}
		
	}
	
	public void addVehicle(Vehicle vehicle) {
		vehicles.add(vehicle);
	}
	
	public void displayAllVehicles() {
		for(Vehicle v:vehicles) {
			v.displayDetails();
		}
	}
	
	public void displayAvailableVehicles() {
		for(Vehicle v:vehicles) {
			if(!v.isRented()) {
				v.displayDetails();
			}
		}
	}
	
	public void rentVehicle(String brand, String model) throws VehicleServiceException  {
		for(Vehicle v:vehicles) {
			if(!v.isRented() && v.getBrand().equalsIgnoreCase(brand) && v.getModel().equalsIgnoreCase(model)) {
				v.rent();
				return;
			}
		}
		throw new VehicleServiceException("Vehicle is not currently available!!");
	}
	
	public void returnVehicle(String brand, String model) throws VehicleServiceException {
		for(Vehicle v:vehicles) {
			if(v.isRented() && v.getBrand().equalsIgnoreCase(brand) && v.getModel().equalsIgnoreCase(model)) {
				v.returnVehicle();
				return;
			}
		}
		throw new VehicleServiceException("Vehicle not found/not rented !!");
	}
	
	public double calculateTotalRentalPriceForRentedVehicles() {
        double price = 0;
        for (Vehicle v : vehicles) {
        	if(v.isRented()) {
        		price += v.getRentalPricePerDay();
        	}
        }
        return price;
    }
	
	public List<Vehicle> getVehicles(){
		return vehicles;
	}
	
	public List<Vehicle> getAvailableVehicles() {
	    List<Vehicle> available = new ArrayList<>();
	    for (Vehicle v : vehicles) {
	        if (!v.isRented()) {
	            available.add(v);
	        }
	    }
	    return available;
	}
	
}