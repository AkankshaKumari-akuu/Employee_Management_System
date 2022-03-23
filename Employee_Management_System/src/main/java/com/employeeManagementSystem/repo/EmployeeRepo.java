package com.employeeManagementSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeeManagementSystem.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}