import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EmployeeService } from '../service/employee.service';
import { NgForm } from '@angular/forms';
import { Employee } from '../model/Employee';

@Component({
  selector: 'app-employee-registration',
  templateUrl: './employee-registration.component.html',
  styleUrls: ['./employee-registration.component.css']
})
export class EmployeeRegistrationComponent implements OnInit {
   employee : Employee;
  constructor(private route:ActivatedRoute,private router: Router,private employeeService:EmployeeService) {
    this.employee= new Employee();
   }
    ngOnInit(): void {
        throw new Error('Method not implemented.');
    }

   onSubmit() {
    this.employeeService.saveEmployee(this.employee).subscribe(data => {this.gotoHomePage()});
   }
 
   gotoHomePage(){
  this.router.navigate(['/employeehome']);
}
}