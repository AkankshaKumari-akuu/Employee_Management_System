package com.employeeManagementSystem.service;

import java.util.ArrayList;
import java.util.List;

/**
 * The EmployeeOperation java class
 * It is perform to employee salary operation
 *  
 *
 */

public class EmployeeOperation {
	
	public List<Double> salaryOperation(double Bp) {
		
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
		
		List<Double> res = new ArrayList<Double>();
		res.add(DA);
		res.add(HRA);
		res.add(Gross);
		res.add(Tax);
		res.add(Net);
		return res;
	}
}
