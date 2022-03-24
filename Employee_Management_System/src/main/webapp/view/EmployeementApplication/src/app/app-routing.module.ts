import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmployeeHomeComponent } from './employee-home/employee-home.component';
import { UserRegistrationComponent } from './user-registration/user-registration.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { OutputAllEmpComponent } from './output-employee/output-employee.component';
import { EmployeeRegistrationComponent } from './employee-registration/employee-registration.component';
const routes: Routes = [
 
 
{path: '', pathMatch:"full", redirectTo:"userLogin"},
{path:'employeehome', component: EmployeeHomeComponent},
{path:'allEmployee/:searchtype', component: OutputAllEmpComponent},
{path:'userRegistration', component: UserRegistrationComponent},
{path:'userLogin', component: UserLoginComponent},
{path:'employeeById/:id/:searchtype', component: OutputAllEmpComponent},
{path:'deleteById/:id/:searchtype', component: OutputAllEmpComponent},
{path:'employeeRegistration', component: EmployeeRegistrationComponent},





];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
