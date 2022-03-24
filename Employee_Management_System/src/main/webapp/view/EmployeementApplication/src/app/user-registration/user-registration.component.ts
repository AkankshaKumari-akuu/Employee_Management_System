import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../model/User';
import { EmployeeService } from '../service/employee.service';


@Component({
  selector: 'app-user-registration',
  templateUrl: './user-registration.component.html',
  styleUrls: ['./user-registration.component.css']
})
export class UserRegistrationComponent implements OnInit {
   user : User;
  constructor(private route:ActivatedRoute,private router: Router,private employeeService:EmployeeService) {
    this.user= new User();
   }

   onSubmit() {
    this.employeeService.registerUser(this.user).subscribe(data => {this.gotoLogInPage()});
  }
gotoLogInPage(){
  this.router.navigate(['/userLogin']);
}
  ngOnInit(): void {
  }

 

}