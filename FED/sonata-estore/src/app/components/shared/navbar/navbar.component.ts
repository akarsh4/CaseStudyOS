import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  goToCart(): void {
    this.router.navigate(['cart'])
  }

  goToHome(): void {
    this.router.navigate(['home'])
  }

  goToAbout(): void {
    this.router.navigate(['about'])
  }

  goToContact(): void {
    this.router.navigate(['contact'])
  }

  goToProfile(): void {
    this.router.navigate(['profile'])
  }

}
