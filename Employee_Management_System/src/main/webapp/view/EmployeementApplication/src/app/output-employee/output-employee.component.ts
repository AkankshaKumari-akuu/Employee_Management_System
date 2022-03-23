import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Employee } from '../model/Employee';
import { EmployeeService } from '../service/employee.service';

@Component({
  selector: 'app-output-employee',
  templateUrl: './output-employee.component.html',
  styleUrls: ['./output-employee.component.css']
})
export class OutputAllEmpComponent implements OnInit {
  	
  constructor(private employeeService:EmployeeService,private route: ActivatedRoute) { }
   Employees:Employee[]=[];
 
  ngOnInit(): void {
	  console.log("in the output");

	  this.employeeService.getAllemp().subscribe(x=>this.Employees=x);
	
		
  };
}

  

