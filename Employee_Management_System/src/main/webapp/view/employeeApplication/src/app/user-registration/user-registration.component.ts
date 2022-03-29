import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../model/User';
import { EmployeeService } from '../service/employee.service';
import * as CryptoJS from 'crypto-js'; 



@Component({
  selector: 'app-user-registration',
  templateUrl: './user-registration.component.html',
  styleUrls: ['./user-registration.component.css']
})
export class UserRegistrationComponent implements OnInit {
   user : User;
   confirmpassword :String= "";
   missmatch:String="";
   EncryptPassword: string="";

  constructor(private route:ActivatedRoute,private router: Router,private employeeService:EmployeeService) {
    this.user= new User();
   }
   encrypt(password:String)
   {
    this.EncryptPassword = CryptoJS.AES.encrypt(this.user.password.trim(), "Encryption").toString();
     return this.EncryptPassword;
   }

   onSubmit() {
    let cryptuser:User=this.user;

     if(this.user.password==this.confirmpassword){
      cryptuser.password=this.encrypt(this.user.password);

      this.employeeService.registerUser(cryptuser).subscribe(data => {this.gotoLogInPage()});
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