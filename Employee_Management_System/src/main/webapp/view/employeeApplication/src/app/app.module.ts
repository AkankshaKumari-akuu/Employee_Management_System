import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { EmployeeService } from './service/employee.service';
import { EmployeeRegistrationComponent } from './employee-registration/employee-registration.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { EmployeeHomeComponent } from './employee-home/employee-home.component';
import { UserRegistrationComponent } from './user-registration/user-registration.component';
import { OutputAllEmpComponent } from './output-employee/output-employee.component';
import { EmployeeEditComponent } from './employee-edit/employee-edit.component';
@NgModule({
  declarations: [
    AppComponent,
    OutputAllEmpComponent,
    UserLoginComponent,
    EmployeeHomeComponent,
    UserRegistrationComponent,
    EmployeeRegistrationComponent,
    EmployeeEditComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [EmployeeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
