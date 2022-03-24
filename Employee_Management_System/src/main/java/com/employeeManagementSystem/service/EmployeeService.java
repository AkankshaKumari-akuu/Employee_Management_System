package com.employeeManagementSystem.service;

import java.util.ArrayList;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeManagementSystem.exception.DuplicateValueException;
import com.employeeManagementSystem.exception.EmployeeNotFound;
import com.employeeManagementSystem.model.Employee;
import com.employeeManagementSystem.repo.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	public ArrayList<Employee> getAllEmployee() {
		ArrayList<Employee> employees = (ArrayList<Employee>) employeeRepo.findAll();
		return employees;
	}
	
	
	public Employee getEmployeeById(int id) {
		Optional<Employee> optEmp = employeeRepo.findById(id);
		if (optEmp.isPresent()) {
			return optEmp.get();
		} else {
			// throw new EmployeeNotFound("Employee not present");
			return null;
		}
	}

	public Employee addEmployee(Employee employee) {
		Optional<Employee> optEmp = employeeRepo.findById(employee.getId());
		if (optEmp.isPresent()) {
			throw new DuplicateValueException("Employee already present");
		} else {
			Employee e = employeeRepo.save(employee);
			return e;
		}
	}

	

	public Object updateEmployee(Employee employee) {
		Optional<Employee> optEmp = employeeRepo.findById(employee.getId());
		if (optEmp.isPresent()) {
			Employee updatedEmployee = employeeRepo.save(employee);
			//return "update completed";
			
			return updatedEmployee;
		} else {
			throw new EmployeeNotFound("Not present that employee");
			
		}
	}

	public String deleteEmployee(Employee employee) {
		Optional<Employee> optEmp = employeeRepo.findById(employee.getId());
		if (optEmp.isPresent()) {
			employeeRepo.delete(employee);
			return "update completed";
		} else {
			throw new EmployeeNotFound("Not present that employee");
		}
	}

}