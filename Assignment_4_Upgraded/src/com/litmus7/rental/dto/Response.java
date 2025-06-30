package com.litmus7.rental.dto;

import java.util.List;

public class Response {
	private Integer statusCode;
	private String errorMessage;
	private List<Vehicle> vehicles;
	
	//getters and setters
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
	public List<Vehicle> getVehicles() {
        return vehicles;
    }
    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
	
	
}
