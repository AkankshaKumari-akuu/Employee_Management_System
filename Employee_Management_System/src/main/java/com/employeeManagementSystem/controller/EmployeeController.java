package com.employeeManagementSystem.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.employeeManagementSystem.model.Employee;
import com.employeeManagementSystem.model.EmployeeOperation;
import com.employeeManagementSystem.model.User;
import com.employeeManagementSystem.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/portal")
@RestController
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")

public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/home")
	public ModelAndView showIndexPage(ModelAndView model) {

		//log.info("start loginpage");
		//log.info("end loginpage");

		model.setViewName("login");
		return model;
	}
	
	@GetMapping("/index")
	public ModelAndView portalPage(ModelAndView model) {
		model.setViewName("index");
		return model;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView userLogin(@RequestParam String userId, String password,ModelAndView model) throws IOException {
		if(employeeService.findUser(userId, password)) {
			model.setViewName("index");
		}
		else {
		model.setViewName("login");
		}
		return model;
	}

	@RequestMapping(value = "/allemployee")
	public ModelAndView listEmployee(ModelAndView model) throws IOException {
		List<Employee> listEmployee = employeeService.getAllEmployee();
		model.addObject("listEmployee", listEmployee);
		model.setViewName("home");
		return model;
	}
	
	
	@GetMapping("/newEmployee")
	public ModelAndView employeeForm(ModelAndView model) {
		Employee employee = new Employee(0,"","",0,0,0,0,0,0);
		model.addObject("employee", employee);
		model.setViewName("EmployeeForm");
		return model;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public ModelAndView seaveEmployee(@RequestParam int id, String empName, @RequestParam String doj, @RequestParam String basicPay, ModelAndView model ) throws IOException {
		if(id==0) {
		Double bp = Double.parseDouble(basicPay);
		EmployeeOperation empop= new EmployeeOperation();
		List<Double> salary = empop.salaryOperation(bp);
		Employee emp = new Employee(empName, doj, bp, salary.get(0), salary.get(1), salary.get(2), salary.get(3), salary.get(4));
		employeeService.addEmployee(emp);
		}
		else {
			Double bp = Double.parseDouble(basicPay);
			EmployeeOperation empop= new EmployeeOperation();
			List<Double> salary = empop.salaryOperation(bp);
			Employee emp = new Employee(id,empName, doj, bp, salary.get(0), salary.get(1), salary.get(2), salary.get(3), salary.get(4));
			employeeService.updateEmployee(emp);
		}
		model.setViewName("index");
		return model;
	}
	
	@RequestMapping(value = "/Search", method = RequestMethod.GET)
	public ModelAndView searEmployee(@RequestParam int empId,ModelAndView model) throws IOException {
		Employee emp = employeeService.getEmployeeById(empId);
		if(emp!=null) {
			model.addObject("employee",emp);
			model.setViewName("employee");
			return model;
		}
		else {
			model.setViewName("success");
			return model;
		}
	}
	
	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(HttpServletRequest request) {
		int employeeId = Integer.parseInt(request.getParameter("id"));
		Employee emp = employeeService.getEmployeeById(employeeId);
		employeeService.deleteEmployee(emp);
		return new ModelAndView("redirect:/portal/allemployee");
	}

	@RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int employeeId = Integer.parseInt(request.getParameter("id"));
		Employee employee = employeeService.getEmployeeById(employeeId);
		ModelAndView model = new ModelAndView("EmployeeForm");
		model.addObject("employee", employee);

		return model;
	}
	
	@GetMapping("/registerUser")
	public ModelAndView registerUser(ModelAndView model) {
		model.setViewName("registerUser");
		return model;
	}
	@PostMapping(path = "/registerUser", consumes = "application/json")
    public void addUser(@RequestBody User user) {
		employeeService.addUser(user);
    
    }
	
	@RequestMapping(value = "/newUser", method = RequestMethod.GET)
	public ModelAndView addUser(HttpServletRequest request,ModelAndView model) {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		int empId=Integer.parseInt(request.getParameter("empId"));
		String userId = request.getParameter("userId");
		String email = request.getParameter("email");
		String password =request.getParameter("password");
		String address= request.getParameter("address");
		
		Employee emp = employeeService.getEmployeeById(empId);
		if(emp!=null) {
		User user = new User(userId, password, firstName, lastName, email, address, emp);
		employeeService.addUser(user);
		model.setViewName("success");
		return model;
		}
		else {
			model.setViewName("fail");
			return model;
		}
	}
	
	@GetMapping(path="/allUserList",produces="application/json")
	public List<User> getAllUser(){
		return employeeService.allUser();
	}
}