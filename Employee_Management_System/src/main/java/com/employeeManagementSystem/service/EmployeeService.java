package com.employeeManagementSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeManagementSystem.exception.DuplicateValueException;
import com.employeeManagementSystem.exception.EmployeeNotFound;
import com.employeeManagementSystem.model.Employee;
import com.employeeManagementSystem.model.User;
import com.employeeManagementSystem.repo.EmployeeRepo;
import com.employeeManagementSystem.repo.UserRepo;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Autowired
	private UserRepo userRepo;
	
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
			//throw new EmployeeNotFound("Employee not present");
			return null;
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
	
	public boolean findUser(String userId, String password) {
		Optional<User> u = userRepo.findById(userId);
		if(u.isPresent()) {
			User user = u.get();
			if(user.getPassword().equals(password)) {
				return true;
			}
			return false;
		}
		return false;
		
	}
	
	public boolean addUser(User user) {
		userRepo.save(user);
		return true;
	}

}
