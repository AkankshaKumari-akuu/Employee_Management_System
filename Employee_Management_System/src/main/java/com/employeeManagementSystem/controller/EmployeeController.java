package com.employeeManagementSystem.controller;

import java.io.IOException;
import java.util.List;

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
import com.employeeManagementSystem.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/portal")
@Controller
@Slf4j
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/")
	public String showIndexPage(@ModelAttribute Employee employee) {

		//log.info("start loginpage");
		//log.info("end loginpage");

		return "index";
	}

	
	@PostMapping("/Search")
	public String searchEmployee(@ModelAttribute int id, ModelMap model, HttpSession session) {
		//log.info("start fetchDetails");

		//log.debug("" + employeeService.getEmployeeById(4));
		//log.info(""+id);
		return "employee";
	}
	
	@RequestMapping(value = "/allemployee")
	public String listEmployee(ModelMap model) throws IOException {
		List<Employee> listEmployee = employeeService.getAllEmployee();
		model.addAttribute("listEmployee", listEmployee);
		return "home";
	}
	@RequestMapping(value = "/newEmployee", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		Employee employee = new Employee();
		model.addObject("employee", employee);
		model.setViewName("EmployeeForm");
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
	
}
