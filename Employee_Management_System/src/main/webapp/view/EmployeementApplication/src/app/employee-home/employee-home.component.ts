import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Employee } from '../model/Employee';

@Component({
  selector: 'app-employee-home',
  templateUrl: './employee-home.component.html',
  styleUrls: ['./employee-home.component.css']
})
export class EmployeeHomeComponent implements OnInit {
  searchtype: string='';
employee:Employee; 
  constructor(private router: Router)
 {
  this.employee = new Employee();
 }
 public formData:any ={};
 allemployee(){
    this.searchtype = 'all';
    this.router.navigate([`allEmployee/${this.searchtype}`]);
 }

 employeeidstatus: boolean = false;
  employeeid() {
    this.employeeidstatus = true;
    this.employeeiddeletestatus = false;
  }
  showEmpById(formdata: NgForm) {
    this.formData = formdata.value;
    this.searchtype = 'byId';
    this.router.navigate([`employeeById/${this.employee.id}/${this.searchtype}`]);
  }
  employeeiddeletestatus: boolean = false;
  employeedeletebyid() {
    this.employeeiddeletestatus = true;
    this.employeeidstatus = false;
  }
  deleteEmpById(formdata: NgForm) {
    this.formData = formdata.value;
    this.searchtype = 'delId';
    this.router.navigate([`allEmployee/${this.employee.id}/${this.searchtype}`]);
  }



  ngOnInit(): void {
   
  }
 
}
