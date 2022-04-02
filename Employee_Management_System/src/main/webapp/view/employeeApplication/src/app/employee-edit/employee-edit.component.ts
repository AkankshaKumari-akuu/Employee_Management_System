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
   employeearr:Employee[]=[];
  constructor(private route:ActivatedRoute,private router: Router,private employeeService:EmployeeService) {
    this.employee= new Employee();
   }
   ngOnInit(): void {
    this.route.params.subscribe((parameters) => {
    this.employeeService.findByIdforEdit(parameters['id']).subscribe(x =>{ this.employee=x});
  });

}
  
onSubmit() {
    this.employeeService.editEmployee(this.employee).subscribe(x => {this.gotoHomePage()});
    alert('Employee successfully update');
   }
   searchtype: string='';
   gotoHomePage(){
    this.searchtype = 'all';
    this.router.navigate([`allEmployee/${this.searchtype}`]);
}
}