package com.employee.dao;

import java.util.List;

import com.employee.model.Employee;

public interface EmployeeDAO {
	public void addEmployee(Employee employee);

	public List<Employee> getAllEmployees();

	public void deleteEmployee(Integer Id);

	public Employee updateEmployee(Employee employee);

	public Employee getEmployee(int id);

}
