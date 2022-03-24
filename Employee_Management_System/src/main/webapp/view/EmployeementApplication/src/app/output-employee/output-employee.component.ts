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
    this.Employees=[];
	this.route.params.subscribe( (parameters)=>{
		
		if (String(parameters['searchtype']).localeCompare('all') == 0) {
      this.employeeService.getAllemp().subscribe(x=>this.Employees=x);
		} 
    else if(String(parameters['searchtype']).localeCompare('byId') == 0){
			this.employeeService.findById(parameters['id']).subscribe(x=>this.Employees=x);
    }
    else if(String(parameters['searchtype']).localeCompare('delId') == 0){
			this.employeeService.deleteById(parameters['id']).subscribe(x=>this.Employees=x);
    }


  });
}
}

  

