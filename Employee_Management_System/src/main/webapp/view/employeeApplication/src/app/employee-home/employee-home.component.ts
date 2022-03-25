import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from '../model/Employee';
import { EmployeeService } from '../service/employee.service';

@Component({
  selector: 'app-employee-home',
  templateUrl: './employee-home.component.html',
  styleUrls: ['./employee-home.component.css']
})
export class EmployeeHomeComponent implements OnInit {

  searchtype: string='';
employee:Employee; 
  Employees: Employee[]=[];
  constructor(private router: Router,private employeeService:EmployeeService,private route: ActivatedRoute)
 {
  this.employee = new Employee();
 }
 public formData:any ={};
 allemployee(){
    this.searchtype = 'all';
    this.router.navigate([`allEmployee/${this.searchtype}`]);
 }

 employeeidstatus: boolean = false;
 employeeEditstatus:boolean=false;
  employeeid() {
    this.employeeidstatus = true;
    this.employeeiddeletestatus = false;
    
  }
  employeeedit()
  {this.employeeidstatus = false;
    this.employeeiddeletestatus = false;
    this.employeeEditstatus=true;
  }
  showEmpById(formdata: NgForm) {
    this.formData = formdata.value;
    this.searchtype = 'byId';
    this.router.navigate([`employeeById/${this.employee.id}/${this.searchtype}`]);
  }
  editEmpById(formdata: NgForm) {
    this.formData = formdata.value;
    this.searchtype = 'editById';
    this.router.navigate([`editemployeeById/${this.employee.id}/${this.searchtype}`]);
  }
  employeeiddeletestatus: boolean = false;
  employeedeletebyid() {
    this.employeeiddeletestatus = true;
    this.employeeidstatus = false;
  }
  showstatus: boolean = false;
  id:Number=0;
  deleteEmpById(formdata: NgForm) {
    this.formData = formdata.value;
    this.searchtype = 'delId';
    //this.router.navigate([`deleteById/${this.employee.id}/${this.searchtype}`]);
    //this.route.params.subscribe( (parameters)=>{

      //if(String(parameters['searchtype']).localeCompare('delId') == 0){
        this.employeeService.deleteById(this.employee.id).subscribe(x=>this.Employees=x);
        this.showstatus = true;
        
        this.id=this.employee.id;
      }
  ngOnInit(): void {


  }  
  
  
  }
  
function ngOnInit() {
  throw new Error('Function not implemented.');
}

