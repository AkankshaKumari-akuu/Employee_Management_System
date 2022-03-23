import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmployeeHomeComponent } from './employee-home/employee-home.component';
import { UserRegistrationComponent } from './user-registration/user-registration.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { OutputAllEmpComponent } from './output-employee/output-employee.component';
const routes: Routes = [
 
  /*{path:'bookByName/:name', component: OutputBookComponent},
  {path:'bookByAuthor/:author', component: OutputBookComponent},
  {path:'bookByCategory/:category', component: OutputBookComponent},
  {path:'libraryhome', component: EmployeeHomeComponent},
  {path:'userRegistration', component: UserRegistrationComponent},


*/
{path:'employeehome', component: EmployeeHomeComponent},
{path:'alEmp', component: OutputAllEmpComponent},
{path:'userRegistration', component: UserRegistrationComponent},
{path:'userLogin', component: UserLoginComponent}



];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
