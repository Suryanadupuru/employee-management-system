package com.example.ems.exception;

public class DepartmentAlreadyExistsException extends RuntimeException {
	
	public DepartmentAlreadyExistsException(String message) {
		super(message);
	}

}
