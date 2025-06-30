package com.litmus7.rental.exception;

public class VehicleServiceException extends Exception {
	public VehicleServiceException(String message) {
		super(message);
	}
	
	public VehicleServiceException(String message,Throwable cause) {
		super(message,cause);
	}
	
}
