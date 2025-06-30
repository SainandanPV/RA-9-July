package com.litmus7.rental.dao;
import com.litmus7.rental.dto.Bike;
import com.litmus7.rental.dto.Car;
import com.litmus7.rental.dto.Vehicle;
import com.litmus7.rental.exception.VehicleDataAccessException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


//Data Access layer
public class VehicleDAO {
	public List<Vehicle> loadVehiclesFromFile(String filepath) throws VehicleDataAccessException{
		List<Vehicle> vehicles=new ArrayList<>();
		try(BufferedReader br=new BufferedReader(new FileReader(filepath))){
			String line;
			while((line=br.readLine())!=null) {
				String[] parts=line.split(",");
				if(parts[0].equalsIgnoreCase("Car") && parts.length==6) {
					Car car=new Car(parts[1],parts[2],Double.parseDouble(parts[3]),Integer.parseInt(parts[4]),Boolean.parseBoolean(parts[5]));
					vehicles.add(car);
				}
				else if(parts[0].equalsIgnoreCase("Bike") && parts.length==6) {
					Bike bike=new Bike(parts[1],parts[2],Double.parseDouble(parts[3]),Boolean.parseBoolean(parts[4]),Integer.parseInt(parts[5]));
					vehicles.add(bike);
				}
			}
		}
		catch(FileNotFoundException e) {
			throw new VehicleDataAccessException("Requested file not found : "+filepath,e);
		}
		catch(IOException e) {
			throw new VehicleDataAccessException("Error reading file: " + filepath, e);
		}
		return vehicles;
	}

}
