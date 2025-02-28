package com.example.ems.exception;

public class EmployeeAlreadyExistsException extends RuntimeException {
	
	public EmployeeAlreadyExistsException(String message) {
		super(message);
	}

}
