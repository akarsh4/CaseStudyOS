import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { user } from 'src/app/models/user';
import { LoginRegisterService } from 'src/app/services/login-register.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: user = new user();
  message: string = '';

  constructor(private router: Router, private loginRegisterService: LoginRegisterService) { }

  ngOnInit(): void {
  }

  loginUser() {
    this.loginRegisterService.loginUser(this.user).subscribe(
      data => {
        console.log("Response Received");
        this.router.navigate(['home'])
      },
      error => {
        console.log('Exception Occured');
        this.message = 'Invalid email or password, please try again';
      }
    )
  }

}
