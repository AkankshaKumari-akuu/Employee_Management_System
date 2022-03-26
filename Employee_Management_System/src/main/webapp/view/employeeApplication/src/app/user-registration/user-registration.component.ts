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
   confirmpassword :String= "";
   missmatch:String="";
  constructor(private route:ActivatedRoute,private router: Router,private employeeService:EmployeeService) {
    this.user= new User();
   }

   onSubmit() {
     if(this.user.password==this.confirmpassword){
      this.employeeService.registerUser(this.user).subscribe(data => {this.gotoLogInPage()});
     }
     else{
       this.missmatch="Password mismatched";
     }
    

  }
gotoLogInPage(){
  this.router.navigate(['/userLogin']);
}
  ngOnInit(): void {
  }

 

}