import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { User } from '../../datamodel/user';
import { UserService } from '../../services/user-service/user.service';
import { AuthService } from '../../services/auth-service/auth.service';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent implements OnInit {

  //to the exam-display
  // @Output()
  // private u: EventEmitter<User> = new EventEmitter<User>();

  public user: User = new User('', '')

  constructor(private userService: UserService, private authService: AuthService) { }

  ngOnInit() {
  }

  save() : void {
    this.userService.save(this.user);
    // this.u.emit(this.user);
  }

  login() : void {
    this.authService.login(this.user);
    this.user = new User('', '');
  }

}
