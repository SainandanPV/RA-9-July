package com.litmus7.retail.exception;

public class DuplicateProductException extends Exception {
	public DuplicateProductException(String message) {
		super(message);
	}
	public DuplicateProductException(String message, Throwable cause) {
		super(message,cause);
	}
	
}
