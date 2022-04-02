import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from '../model/User';
import { EmployeeService } from '../service/employee.service';
import * as CryptoJS from 'crypto-js'; 

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {
  status:boolean=false;
  error:boolean=false;
  users:User[]=[];
  name:string | undefined;
  public formData:any ={};
  decryptedPassword: any;



  constructor(private employeeService:EmployeeService,private router: Router){

  }

  decrypt(password:String)
  {
    this.decryptedPassword = CryptoJS.AES.decrypt(password.trim(), "Encryption").toString(CryptoJS.enc.Utf8);
    return this.decryptedPassword;
  }
  
  
  ngOnInit():void{
    this.employeeService.getAllUser().subscribe(alluser=>this.users=alluser);
  }

  userLogin(formdata:NgForm)
  {
    this.formData=formdata.value;
    this.users.forEach(user => {
    if(user.userid==this.formData.username&&this.decrypt(user.password)==this.formData.password)
    {
    this.status=true;
    this.name=user.first+" "+user.last;
    console.log (user.userid);
    console.log (user.password);
    }
   
  });
    
    if(this.status==true)
    {
      this.router.navigate(['employeehome']);
    }
    else
    {
      this.error=true;
    }
  }

}