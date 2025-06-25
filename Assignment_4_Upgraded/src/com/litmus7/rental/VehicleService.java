package com.litmus7.rental;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.litmus7.rental.dto.*;

public class VehicleService {
	private List<Vehicle> vehicles=new ArrayList<>();
	
	public void loadVehicles(String filepath) {
		try(BufferedReader br=new BufferedReader(new FileReader(filepath))){
			String line;
			while((line=br.readLine())!=null) {
				String[] parts=line.split(",");
				if(parts.length==6 && parts[0].equals("Car")) {
					Car car=new Car(parts[1], 
							parts[2],
							Double.parseDouble(parts[3]),
							Integer.parseInt(parts[4]),
							Boolean.parseBoolean(parts[5]));
					vehicles.add(car);
				}
				else if (parts[0].equalsIgnoreCase("Bike") && parts.length == 6) {
                    Bike bike=new Bike(parts[1],
                    		parts[2],
                            Double.parseDouble(parts[3]),
                            Boolean.parseBoolean(parts[4]),
                            Integer.parseInt(parts[5]));
                    vehicles.add(bike);
                }
			}
		}
		catch(IOException e) {
			System.out.println("Error Reading File : "+e.getMessage());
		}
	}
	
	public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void displayAllVehicles() {
        for (Vehicle v : vehicles) {
            v.displayDetails();
        }
    }
    
    public void displayAvailableVehicles() {
        for (Vehicle v : vehicles) {
            if (v.isRented()==false) {
                v.displayDetails();
            }
        }
    }
    
    public boolean rentVehicle(String brand, String model) {
        for (Vehicle v : vehicles) {
            if (v.isRented()==false &&
                v.getBrand().equals(brand) &&
                v.getModel().equals(model)) {
                v.rent();
                return true;
            }
        }
        return false;
    }

    public boolean returnVehicle(String brand, String model) {
        for (Vehicle v : vehicles) {
            if (v.isRented()==true &&
                v.getBrand().equalsIgnoreCase(brand) &&
                v.getModel().equalsIgnoreCase(model)) {
                v.returnVehicle();
                return true;
            }
        }
        return false;
    }
    
    public double calculateRent() {
    	double total=0;
    	for(Vehicle v :vehicles) {
    		total+=v.getRentalPricePerDay(); 
    	}
    	return total;
    }
    
    

    public List<Vehicle> getVehicles() {
        return vehicles;
    }
}