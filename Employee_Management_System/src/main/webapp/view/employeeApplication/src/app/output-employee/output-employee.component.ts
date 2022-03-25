import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from '../model/Employee';
import { EmployeeService } from '../service/employee.service';

@Component({
  selector: 'app-output-employee',
  templateUrl: './output-employee.component.html',
  styleUrls: ['./output-employee.component.css']
})
export class OutputAllEmpComponent implements OnInit {
  employee: Employee = new Employee;
  showEdit: boolean = false;
  	
  constructor(private employeeService:EmployeeService,private router: Router,private route: ActivatedRoute) { }
   Employees:Employee[]=[];
   showOutput:boolean=true;
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
    else if(String(parameters['searchtype']).localeCompare('editById') == 0){
			this.employeeService.findByIdforEdit(parameters['id']).subscribe(x=>{this.employee=x});
     this.showEdit=true;
     this.showOutput=false;
    }
    


  });
}
onSubmit() {
  this.employeeService.editEmployee(this.employee).subscribe(data => {this.gotoHomePage()});
 }
 searchtype: string='';
 gotoHomePage(){
  this.searchtype = 'all';
  this.router.navigate([`allEmployee/${this.searchtype}`]);
}
}

  

