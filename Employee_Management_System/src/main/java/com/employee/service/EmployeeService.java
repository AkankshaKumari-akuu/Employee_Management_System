package com.employee.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

 
import com.employee.doa.EmployeeDAO;
import com.employee.model.Employee;

@Path("/employeeService")
public class EmployeeService{
	@GET
	@Path("/displayemployee")
	@Produces("text/plain")
	public static Employee getEmployeeDetails(int id) {
		EmployeeDAO empDao= new EmployeeDAO();
		List<Employee> empList= empDao.findById(id);
		//System.out.println(empList.get(0));
		return empList.get(0);
	}
	
	@GET
	@Path("/displayemployee")
	@Produces("text/plain")
	public static List<Employee> getAllEmployee() {
		EmployeeDAO empDao= new EmployeeDAO();
		List<Employee> empList= empDao.getAllEmployee();
		return empList;
	}
	
	@GET
	@Path("/displayemployee")
	@Produces("text/plain")
	public static void addEmployee(Employee e) {
		EmployeeDAO empDao= new EmployeeDAO();
		empDao.saveEmployee(e);
	}
}
