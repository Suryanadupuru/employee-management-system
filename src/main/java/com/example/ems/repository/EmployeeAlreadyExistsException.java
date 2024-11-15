package com.example.ems.repository;

public class EmployeeAlreadyExistsException extends RuntimeException {
	
	public EmployeeAlreadyExistsException(String message) {
		super(message);
	}

}
