package com.employeeManagementSystem.service;

import java.util.List;
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
	
	public Employee addEmployee(Employee employee) {
		Optional<Employee> optEmp = employeeRepo.findById(employee.getId());
		if(optEmp.isPresent()) {
			throw new DuplicateValueException("Employee already present");
		}
		else {
			Employee e = employeeRepo.save(employee);
			return e;
		}
	}
	
	public Employee getEmployeeById(int id) {
		Optional<Employee> optEmp = employeeRepo.findById(id);
		if(optEmp.isPresent()) {
			return optEmp.get();
		}
		else {
			throw new EmployeeNotFound("Employee not present");
		}
	}
	
	public List<Employee> getAllEmployee(){
		List<Employee> employees= employeeRepo.findAll();
		return employees;
	}
	
	public String updateEmployee(Employee employee) {
		Optional<Employee> optEmp = employeeRepo.findById(employee.getId());
		if(optEmp.isPresent()) {
			employeeRepo.save(employee);
			return "update completed";
		}
		else {
			throw new EmployeeNotFound("Not present that employee");
		}
	} 
	
	public String deleteEmployee(Employee employee) {
		Optional<Employee> optEmp = employeeRepo.findById(employee.getId());
		if(optEmp.isPresent()) {
			employeeRepo.delete(employee);
			return "update completed";
		}
		else {
			throw new EmployeeNotFound("Not present that employee");
		}
	}

}
