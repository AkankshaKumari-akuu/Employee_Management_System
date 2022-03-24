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
  registerEmployee(user: User) {
      throw new Error('Method not implemented.');
  }
  allemplink:string;
  AllUserList: string;
  validateUserUrl: string;
  registerUserUrl:string;
  findEmployeeByIdUrl: string;
  deleteEmployeeByIdUrl: string;
  editEmployeeByIdUrl: string;
  saveEmployeeUrl: string;
  

  constructor(private http: HttpClient) { 
    this.AllUserList='http://localhost:9091/allUserList';
    this.allemplink='http://localhost:9091/allEmployeeList';
    this.registerUserUrl='http://localhost:9091/registerUser';
    this.findEmployeeByIdUrl='http://localhost:9091/employee/';
    this.deleteEmployeeByIdUrl='http://localhost:9091/deleteEmployee/';
    this.editEmployeeByIdUrl='http://localhost:9091/editEmployee';
    this.saveEmployeeUrl='http://localhost:9091/saveEmployee';

    this.validateUserUrl='http://localhost:9091/portal/validateUser';
   
  }

  public getAllUser(): Observable<User[]>{
    return this.http.get<User[]>(this.AllUserList);
  }

  public registerUser(user: User) {
    return this.http.post<User>(this.registerUserUrl, user);
    }

  public getAllemp(): Observable<Employee[]>{
    return this.http.get<Employee[]>(this.allemplink);
  }
  public findById( id:string): Observable<Employee[]>{
      console.log("intheservice");
      return this.http.get<Employee[]>(this.findEmployeeByIdUrl+id);
  }

  public deleteById( id:string): Observable<Employee[]>{
    console.log("intheservice");
    return this.http.get<Employee[]>(this.deleteEmployeeByIdUrl+id);
}

public saveEmployee(employee:Employee){
  return this.http.post<Employee>(this.saveEmployeeUrl, employee);
}
  
  
  
  }
 