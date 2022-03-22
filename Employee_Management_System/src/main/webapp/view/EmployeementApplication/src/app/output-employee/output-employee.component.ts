import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../service/User.service';
import { User } from '../model/User';

@Component({
  selector: 'app-User_form',
  templateUrl: './User_form.component.html',
  styleUrls: ['./User_form.component.css']
})
export class UserFormComponent {

  user: User;

  constructor(private route: ActivatedRoute, private router: Router, private userService: UserService) {
    this.user = new User();
  }

   
}
