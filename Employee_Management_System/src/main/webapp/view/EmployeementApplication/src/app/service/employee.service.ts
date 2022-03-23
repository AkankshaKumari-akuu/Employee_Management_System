import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
//import { Observable } from 'rxjs-compat/Observable';
import { Observable } from 'rxjs';
import { Employee } from '../model/Employee';
import { User } from '../model/User';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
 
  AllUserList: string;
  allemplink:string;
  validateUserUrl: string;
  registerUserUrl:string;

  constructor(private http: HttpClient) { 
    this.AllUserList='http://localhost:9091/portal/allUserList';
    this.allemplink='http://localhost:9091/portal/allemployee';
    this.registerUserUrl='http://localhost:9091/portal/registerUser';


    this.validateUserUrl='http://localhost:8098/validateUser';
   
  }

  public getAllUser(): Observable<User[]>{
    return this.http.get<User[]>(this.AllUserList);
  }
  public getAllemp(): Observable<Employee[]>{
    return this.http.get<Employee[]>(this.allemplink);
  }
  public registerUser(user: User) {
    return this.http.post<User>(this.registerUserUrl, user);
    }
  
  
  
  }
 