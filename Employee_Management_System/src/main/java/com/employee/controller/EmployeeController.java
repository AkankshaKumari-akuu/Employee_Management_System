package com.employee.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;

public class EmployeeController {
	public EmployeeController() {
		System.out.println("EmployeeController()");
	}
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ModelAndView listEmployee(ModelAndView model) throws IOException {
		List<Employee> listEmployee = employeeService.getAllEmployees();
		model.addObject("listEmployee", listEmployee);
		model.setViewName("home");
		return model;
	}
	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute Employee employee) {
		if (employee.getId() == 0) { 
			employeeService.addEmployee(employee);
		} else {
			employeeService.updateEmployee(employee);
		}
		return new ModelAndView("redirect:/");
	}
	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		employeeService.deleteEmployee(id);
		return new ModelAndView("redirect:/");
	}
	@RequestMapping(value = "/updateEmployee", method = RequestMethod.POST)
	public ModelAndView updateEmployee(HttpServletRequest request, Employee employee) {
		int id = Integer.parseInt(request.getParameter("id"));
		employeeService.updateEmployee(employee);
		return new ModelAndView("redirect:/");
	}
	@RequestMapping(value = "/getEmployee", method = RequestMethod.POST)
	public ModelAndView getEmployee(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		employeeService.getEmployee(id);
		return new ModelAndView("redirect:/");
	}
   
}
