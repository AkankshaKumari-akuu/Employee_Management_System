package com.employeeManagementSystem.exception;

/*
 *EmployeeNotFound Exception Class Will be Thrown when   employee is not found in database
 */
public class EmployeeNotFound extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public EmployeeNotFound(String message) {
		super(message);
	}
}
