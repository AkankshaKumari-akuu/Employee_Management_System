package com.employeeManagementSystem.exception;

/*
 *DuplicateValueException Exception Class Will be Thrown when dublicate employee is not found in database
 */

public class DuplicateValueException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public DuplicateValueException(String message) {
		super(message);
	}
}
