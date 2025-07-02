package com.litmus7.rental.dto;


public class Response<T> {
	private Integer statusCode;
	private String errorMessage;
	private T data;
	
	public Response() {}
	public Response(int statusCode, String errorMessage, T data) {
		this.statusCode = statusCode;
        this.errorMessage = errorMessage;
        this.data = data;
	}
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
	
	public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
	
	
}
