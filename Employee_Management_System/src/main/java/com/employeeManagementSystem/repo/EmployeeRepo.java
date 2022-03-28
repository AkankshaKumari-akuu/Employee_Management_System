package com.employeeManagementSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeeManagementSystem.model.Employee;

/*
 * Implementing the EmployeeRepo Class to do All the Database operation
 */

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}