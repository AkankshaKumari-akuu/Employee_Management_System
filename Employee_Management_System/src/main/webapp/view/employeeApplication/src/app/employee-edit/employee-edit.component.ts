import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EmployeeService } from '../service/employee.service';
import { NgForm } from '@angular/forms';
import { Employee } from '../model/Employee';

@Component({
  selector: 'app-employee-edit',
  templateUrl: './employee-edit.component.html',
  styleUrls: ['./employee-edit.component.css']
})
export class EmployeeEditComponent implements OnInit {
   employee : Employee;
  constructor(private route:ActivatedRoute,private router: Router,private employeeService:EmployeeService) {
    this.employee= new Employee();
   }
    ngOnInit(): void {
        throw new Error('Method not implemented.');
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