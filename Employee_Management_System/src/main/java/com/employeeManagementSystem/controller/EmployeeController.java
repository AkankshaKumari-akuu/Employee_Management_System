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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.employeeManagementSystem.model.Employee;
import com.employeeManagementSystem.model.EmployeeOperation;
import com.employeeManagementSystem.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/portal")
@Controller
@Slf4j
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/home")
	public String showIndexPage(@ModelAttribute Employee employee) {

		//log.info("start loginpage");
		//log.info("end loginpage");

		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String userLogin(@RequestParam String userId, String password,ModelAndView model) throws IOException {
		if(employeeService.findUser(userId, password)) {
			return "index";
		}
		else {
			return "login";
		}
	}

	@RequestMapping(value = "/allemployee")
	public ModelAndView listEmployee(ModelAndView model) throws IOException {
		List<Employee> listEmployee = employeeService.getAllEmployee();
		model.addObject("listEmployee", listEmployee);
		model.setViewName("home");
		return model;
	}
	
	
	@GetMapping("/newEmployee")
	public String employeeForm(@ModelAttribute Employee employee) {
		return "EmployeeForm";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public String seaveEmployee(@RequestParam int id, String empName, @RequestParam String doj, @RequestParam String basicPay ) throws IOException {
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
		return "success";
	}
	
	@RequestMapping(value = "/Search", method = RequestMethod.GET)
	public ModelAndView searEmployee(@RequestParam int empId,ModelAndView model) throws IOException {
		Employee emp = employeeService.getEmployeeById(empId);
		model.addObject("employee",emp);
		model.setViewName("employee");
		return model;
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
}
