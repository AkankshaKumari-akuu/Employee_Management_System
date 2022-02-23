package com.employee.main;

import java.util.List;

import com.employee.dao.EmployeeDAO;
import com.employee.model.Employee;
import com.employee.model.EmployeeOperation;

public class Main {
	public static void main(String[] args) {

		Double Bp=(double) 40000f;
		EmployeeOperation empops = new EmployeeOperation();
		List<Double> salaris=empops.salaryOperation(Bp);
		Employee emp= new Employee("Akku", "10-12-2020", Bp, salaris.get(0),salaris.get(1),salaris.get(2),salaris.get(3),salaris.get(4));
		
		EmployeeDAO empDao= new EmployeeDAO();
		empDao.saveEmployee(emp);
		
		System.out.println(empDao.findById(2));
		
		empDao.deleteEmployeeById(3);
	}
}
