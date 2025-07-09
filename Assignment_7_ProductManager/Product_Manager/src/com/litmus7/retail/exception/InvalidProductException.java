package com.litmus7.retail.exception;

public class InvalidProductException extends Exception {
	public InvalidProductException(String message) {
        super(message);
    }

    public InvalidProductException(String message, Throwable cause) {
        super(message, cause);
    }
}
