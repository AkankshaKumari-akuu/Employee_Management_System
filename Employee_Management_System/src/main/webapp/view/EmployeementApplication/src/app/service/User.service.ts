import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../model/User';
import { Employee } from '../model/Employee';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private usersUrl: string;
  private employeeUrl: string;
  private loginUrl: string;
  private indexUrl: string;
  private allemployeeUrl: string;
  private newEmployeeUrl: string;
  private saveUrl: string;
  private SearchUrl: string;
  private deleteEmployeeUrl: string;
  private registerUserUrl: string;
  private editEmployeeUrl: string;
   
  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8085/EmployeementApplication/newUser';
    this.employeeUrl = 'http://localhost:8085/EmployeementApplication/newEmployee';
    this.loginUrl = 'http://localhost:8085/EmployeementApplication/login';
    this.indexUrl = 'http://localhost:8085/EmployeementApplication/index';
    this.allemployeeUrl = 'http://localhost:8085/EmployeementApplication/allemployee';
    this.newEmployeeUrl = 'http://localhost:8085/EmployeementApplication/newEmployee';
    this.saveUrl = 'http://localhost:8085/EmployeementApplication/save';
    this.SearchUrl = 'http://localhost:8085/EmployeementApplication/Search';
    this.deleteEmployeeUrl = 'http://localhost:8085/EmployeementApplication/deleteEmployee';
    this.registerUserUrl = 'http://localhost:8085/EmployeementApplication/registerUser';
    this.editEmployeeUrl = 'http://localhost:8085/EmployeementApplication/editEmployee';
  }

  public newUser(): Observable<User[]> {
    return this.http.get<User[]>(this.usersUrl);
  }
 
  public userLogin(): Observable<User[]> {
 
    return this.http.get<User[]>(this.loginUrl);
  }
  public portalPage(): Observable<Employee[]> {
    return this.http.get<Employee[]>(this.employeeUrl);
  }

public listEmployee(): Observable<Employee[]> {
  return this.http.get<Employee[]>(this.allemployeeUrl);
}
public employeeForm(): Observable<Employee[]> {
  return this.http.get<Employee[]>(this.newEmployeeUrl);
}
public seaveEmployee(): Observable<Employee[]> {
  return this.http.get<Employee[]>(this.saveUrl);
}
public searEmployee(): Observable<Employee[]> {
  return this.http.get<Employee[]>(this.SearchUrl);
}
public deleteEmployee(): Observable<Employee[]> {
  return this.http.get<Employee[]>(this.deleteEmployeeUrl);
} 
public registerUser(): Observable<User[]> {
  return this.http.get<User[]>(this.registerUserUrl);
} 
public editContact(): Observable<Employee[]> {
  return this.http.get<Employee[]>(this.editEmployeeUrl);
} 
}
