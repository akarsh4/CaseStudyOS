import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Product } from 'src/app/models/product';
import { Cart } from '../../models/cart';
import { CartService } from '../../services/cart.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  /* carts !: Observable<Cart[]>
   items = this.cartService.getItems();
   Total!:number;
 cartItems = [];
 cartTotal=0;
 
   constructor(private cartService: CartService,
     private router: Router) { }
 
   ngOnInit() {
   }
 
   removeItem(i: number) {
     this.cartService.removeItem(i);
   }
   plus(item:any){
     
     item.prodPrice=(item.prodQuantity+1)*item.prodPrice;
 }
 
 calcCartTotal(){
   this.cartTotal = 0;
   this.cartItems.forEach(item=>{
     this.cartTotal += (item.qty*item.prod_price)
   })
 }*/
  public products: any = [];
  public grandTotal: number = 0;
  quantity: number = 1;
  Total!: number;
  a: number = 1;

  constructor(private cartService: CartService) { }

  ngOnInit(): void {

    this.cartService.getProducts()
      .subscribe(res => {
        this.products = res;
        this.grandTotal = this.cartService.getTotalPrice();
      })
  }

  removeItem(i: any) {
    this.cartService.removeCartItem(i);
  }

  emptycart() {
    this.cartService.removeAllCart();
  }

  plus(item: any) {
    item.prodPrice = (item.prodQuantity + 1) * item.prodPrice;
  }

  getgrandTotal(): number {
    this.products
    console.log(this.grandTotal);
    return <number>this.grandTotal;
  }

}
