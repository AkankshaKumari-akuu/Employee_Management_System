import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../service/User.service';
 

@Component({
  selector: 'app-root',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class AppComponent {
  constructor(private route: ActivatedRoute, private router: Router, private userService: UserService) {
     
  }
  gotoUserList() {
    this.router.navigate(['/users']);
  }
   
}
