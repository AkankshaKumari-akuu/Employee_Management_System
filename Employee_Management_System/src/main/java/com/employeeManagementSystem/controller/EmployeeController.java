package com.employeeManagementSystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employeeManagementSystem.model.Employee;
import com.employeeManagementSystem.model.User;
import com.employeeManagementSystem.service.EmployeeOperation;
import com.employeeManagementSystem.service.EmployeeService;
import com.employeeManagementSystem.service.UserService;

/*
 * ib
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private UserService userservice;

	// DoneibAngular checked
	@GetMapping(path = "/allUserList", produces = "application/json")
	public ArrayList<User> getAllUser() {
		return userservice.getAllUser();
	}

	// Done Angular checked
	@PostMapping(path = "/registerUser", consumes = "application/json")
	public void addUser(@RequestBody User user) {
		userservice.saveUser(user);
	}

	// doneIB Angular checked
	@GetMapping(path = "/allEmployeeList", produces = "application/json")
	public ArrayList<Employee> getAllEmployee() {
		return employeeService.getAllEmployee();
	}

	// Search Employee By IB Id
	// Done Angular checked
	@GetMapping(value = "/employee/{id}", produces = "application/json")
	public ArrayList<Employee> getEmployee(@PathVariable int id) {
		System.out.println(id);
		ArrayList<Employee> emp = new ArrayList<Employee>();
		emp.add(employeeService.getEmployeeById(id));
		return emp;
	}
	
	@GetMapping(value = "/edit/employee/{id}", produces = "application/json")
	public Employee getEmployeeEdit(@PathVariable int id) {
		System.out.println(id);
	return	employeeService.getEmployeeById(id);
		
	}

	// Delete Employee
	@GetMapping(value = "/deleteEmployee/{id}")
	public void deleteEmployee(@PathVariable int id) {
		Employee emp = employeeService.getEmployeeById(id);
		employeeService.deleteEmployee(emp);
	}

	@PostMapping(value = "/editEmployee", produces = "application/json", consumes = "application/json")
	public Employee editContact(@RequestBody Employee employee) {
		// employeeService.getEmployeeById(employee.getId());
		Double bp = employee.getBasicpay();
		EmployeeOperation empop = new EmployeeOperation();
		List<Double> salary = empop.salaryOperation(bp);
		Employee emp = new Employee(employee.getId(), employee.getName(), employee.getDateOfJoining(), bp,
				salary.get(0), salary.get(1),
				salary.get(2), salary.get(3), salary.get(4));
		return (Employee) employeeService.updateEmployee(emp);
	}

	// SaveEmployee
	@PostMapping(path = "/saveEmployee", consumes = "application/json", produces = "application/json")
	public Employee addEmployee(@RequestBody Employee employee) {
		Double bp = employee.getBasicpay();
		EmployeeOperation empop = new EmployeeOperation();
		List<Double> salary = empop.salaryOperation(bp);
		Employee emp = new Employee(employee.getId(), employee.getName(), employee.getDateOfJoining(), bp,
				salary.get(0), salary.get(1),
				salary.get(2), salary.get(3), salary.get(4));
		return employeeService.addEmployee(emp);
	}

}
