import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Order } from 'src/app/models/order';
import { OrderService } from 'src/app/services/order.service';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {

  order = new Order;
  msg = '';

  constructor(private service: OrderService, private http: HttpClient, private router: Router) { }

  ngOnInit(): void {
  }

  placeOrder() {
    this.service.placeOrder(this.order).subscribe(
      data => {
        console.log("response recieved");
        this.msg = "order success";
        if (true) {
          this.goToOrderSuccess();
        }
      }, error => {
        console.log("exception occured");
        this.msg = error.error;
      }
    )
  }

  goToOrderSuccess() {
    this.router.navigate(["ordersuccess"]);
  }

}

