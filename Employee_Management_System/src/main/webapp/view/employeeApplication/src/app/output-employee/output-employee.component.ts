import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from '../model/Employee';
import { EmployeeService } from '../service/employee.service';

@Component({
  selector: 'app-output-employee',
  templateUrl: './output-employee.component.html',
  styleUrls: ['./output-employee.component.css']
})
export class OutputAllEmpComponent implements OnInit {
  employeearr: Employee[]=[];
  employee: Employee = new Employee;
  status: boolean = false;
  error: boolean =false;
  public firData: any = {};
  errorst:String='';
  employeeobj2: Employee = new Employee;
  employeeidstatusEl : boolean=false;
  statusdlt:boolean=false;
  constructor(private employeeService: EmployeeService, private route: ActivatedRoute, private router: Router) {
  this.employee = new Employee();
  this.employeeobj2= new Employee();
  this.status=false;
  }
  ngOnInit(): void {
	  console.log("in the output");
     
	this.route.params.subscribe( (parameters)=>{
		
		if (String(parameters['searchtype']).localeCompare('all') == 0) {
      this.employeeService.getAllemp().subscribe(x=>this.employeearr=x);
	
    } 
     else if(String(parameters['searchtype']).localeCompare('byId') == 0){
			this.employeeService.findById(parameters['id']).subscribe(x=>this.employeearr=x);
    }
     
    
    

  });
  
}
  deleteEmpById(employeeobj:Employee){
    if(window.confirm('are you sure you want delete this Employee')){
      this.employeeService.deleteById(employeeobj.id).subscribe(data=>{
        this.employeeService.getAllemp().subscribe(x=>{
          this.employeearr=[];
          this.employeearr=x;}
          );
        

      });
      alert("Employee Successfully Deleted");
    }

  }
   
  editEmpById(employeeobj:Employee){
    this.employee.id=employeeobj.id;
     
    this.router.navigate([`editById/${this.employee.id}`]);
  }
   
   
   
  	
}
	   
