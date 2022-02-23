package com.employee.controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.dao.EmployeeDAO;

/**
 * Servlet implementation class EmployeeController
 */

@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
   /* public EmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }*/

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		out.print("hello");
		out.println("<h1>Employee details </h1>");
		EmployeeDAO employeedao= new EmployeeDAO();
		out.println(employeedao.findById(3));
	
	}
}