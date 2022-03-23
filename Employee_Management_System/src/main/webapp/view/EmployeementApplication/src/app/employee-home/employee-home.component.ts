import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employee-home',
  templateUrl: './employee-home.component.html',
  styleUrls: ['./employee-home.component.css']
})
export class EmployeeHomeComponent implements OnInit {
  namestatus:boolean=false;
  constructor(private router: Router)
 {

 }
 public formData:any ={};
 allemployee(){
  
    this.router.navigate(['alEmp']);
 }
 
 booknamestatus() {
  this.namestatus=true;
}

 

  ngOnInit(): void {
   
  }
 
}
