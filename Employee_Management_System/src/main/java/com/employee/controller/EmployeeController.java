package com.employee.controller;

import java.util.Date;

import com.employee.doa.EmployeeDoa;
import com.employee.model.Employee;

public class EmployeeController {
	public static void main(String[] args)
	{ 
		Double Bp=(double) 40000f;
		Double DA=Bp*0.4;
		Double HRA=Bp*0.3;
		Double Gross=Bp+DA+HRA;
		
		Double Tax=(double) 0;
		if(Gross>15000000)
		{
			Tax=Gross*0.3;
		}
		else if (Gross>1000000)
			
		{
			Tax=Gross*0.2;
		}
        else if (Gross>500000)
			
		{
			Tax=Gross*0.1;
		}
        else
        {
			Tax=(double) 0;
			
		}
		Double Net=Gross-Tax;
		
		Employee emp= new Employee( "Akku", new Date(2000,11,2), Bp, DA, HRA, Gross, Tax, Net);
		EmployeeDoa empdoa=new EmployeeDoa();
		empdoa.insertEmployee(emp);
		
		Employee e= empdoa.findEmployee(1);
		System.out.println(e);
	}
	

	

}
