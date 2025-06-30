package com.litmus7.rental.exception;

public class VehicleDataAccessException extends Exception {
	public VehicleDataAccessException(String message,Throwable cause) {
		super(message,cause);
	}
	public VehicleDataAccessException(String message) {
		super(message);
	}
}
