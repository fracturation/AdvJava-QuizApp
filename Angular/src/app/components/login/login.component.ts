import { Component, OnInit } from '@angular/core';
import { User } from '../../datamodel/user';
import { AuthService } from '../../services/auth-service/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public user: User = new User('','');

  constructor(private authService: AuthService) { }

  ngOnInit() {
  }

  login() : void {
    this.authService.login(this.user);
    this.user = new User('','');
  }

}
