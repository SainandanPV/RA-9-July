package com.litmus7.rental.controller;

import java.util.List;
import com.litmus7.rental.dto.Bike;
import com.litmus7.rental.dto.Car;
import com.litmus7.rental.dto.Response;
import com.litmus7.rental.dto.Vehicle;
import com.litmus7.rental.exception.VehicleServiceException;
import com.litmus7.rental.service.VehicleService;

public class VehicleController {

    private final VehicleService service;
    private static final int SUCCESS_STATUS_CODE = 200;
    private static final int ERROR_STATUS_CODE = 500;

    public VehicleController() {
        this.service = new VehicleService();
    }

    public VehicleController(VehicleService service) {
        this.service = service;
    }

    /** Load vehicles from file */
    public Response<List<Vehicle>> loadVehiclesFromFile(String filepath) {
        try {
            List<Vehicle> loadedVehicles = service.loadVehicles(filepath);
            return new Response<>(SUCCESS_STATUS_CODE, null, loadedVehicles);
        } catch (VehicleServiceException e) {
            return new Response<>(ERROR_STATUS_CODE, e.getMessage(), null);
        }
    }

    /** Add a generic vehicle */
    public void addVehicle(Vehicle vehicle) {
        service.addVehicle(vehicle);
    }

    /** Get all vehicles */
    public Response<List<Vehicle>> getAllVehicles() {
        return new Response<>(SUCCESS_STATUS_CODE, null, service.getVehicles());
    }

    /** Get available vehicles */
    public Response<List<Vehicle>> getAvailableVehicles() {
        return new Response<>(SUCCESS_STATUS_CODE, null, service.getAvailableVehicles());
    }

    /** Add car using parameters */
    public Response<String> addCar(String brand, String model, double price, int doors, boolean isAuto) {
        Vehicle car = new Car(brand, model, price, doors, isAuto);
        service.addVehicle(car);
        return new Response<>(SUCCESS_STATUS_CODE, null, "Car added successfully!");
    }

    /** Add bike using parameters */
    public Response<String> addBike(String brand, String model, double price, boolean hasGear, int capacity) {
        Vehicle bike = new Bike(brand, model, price, hasGear, capacity);
        service.addVehicle(bike);
        return new Response<>(SUCCESS_STATUS_CODE, null, "Bike added successfully!");
    }

    /** Rent a vehicle */
    public Response<String> rentVehicle(String brand, String model) {
        try {
            service.rentVehicle(brand, model);
            return new Response<>(SUCCESS_STATUS_CODE, null, "Vehicle rented successfully!");
        } catch (VehicleServiceException e) {
            return new Response<>(ERROR_STATUS_CODE, e.getMessage(), null);
        }
    }

    /** Return a rented vehicle */
    public Response<String> returnVehicle(String brand, String model) {
        try {
            service.returnVehicle(brand, model);
            return new Response<>(SUCCESS_STATUS_CODE, null, "Vehicle returned successfully!");
        } catch (VehicleServiceException e) {
            return new Response<>(ERROR_STATUS_CODE, e.getMessage(), null);
        }
    }

    /** Calculate revenue */
    public Response<Double> calculateRevenue() {
        double total = service.calculateTotalRentalPriceForRentedVehicles();
        return new Response<>(SUCCESS_STATUS_CODE, null, total);
    }
}
