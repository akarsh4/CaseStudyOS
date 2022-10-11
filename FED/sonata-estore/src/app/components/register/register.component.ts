import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginRegisterService } from 'src/app/services/login-register.service'; 
import { user } from 'src/app/models/user';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user: user = new user();
  message: string ='';

  constructor(public router: Router, private loginRegisterService: LoginRegisterService) { }

  ngOnInit(): void {
  }

  registerUser(): void {
    this.loginRegisterService.registerUser(this.user).subscribe(
      data => {
        console.log("Response Received");
        this.router.navigate(['login']);
        alert("Register Successful, please login")
      },
      error => {
        console.log("Exception Occured");
        this.message = error.error;
      }
    )
  }

}
