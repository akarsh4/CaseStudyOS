import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product } from '../models/product';
import { Cart } from '../models/cart';
import { BehaviorSubject } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class CartService {
  /*
    items: Cart[] = [];
    
  
    constructor(private http: HttpClient) { }
  
    addToCart(product: Product) {
      this.items.push(product);
    }
  
    getItems() {
      return this.items;
    }
  
    removeItem(i: number) {
      this.items.splice(i, 1);
    }
  
    clearCart() {
      this.items = [];
      return this.items;
    }
    total():number{
      let grandTotal=0;
      this.items.map((a:any)=>{
        grandTotal+=a.total;
      })
      return grandTotal;
    }
  */
  public cartItemList: any = []
  public productList = new BehaviorSubject<any>([]);
  public search = new BehaviorSubject<string>("");
  quantity: number = 1;
  item!: number;
  product!: number;

  constructor() { }

  getProducts() {
    return this.productList.asObservable();
  }

  setProduct(product: any) {
    this.cartItemList.push(...product);
    this.productList.next(product);
  }

  addtoCart(product: any) {
    this.cartItemList.push(product);
    this.productList.next(this.cartItemList);
    this.getTotalPrice();
    console.log(this.cartItemList)
  }

  getTotalPrice(): number {
    let grandTotal = 0;
    this.cartItemList.map((a: any) => {
      grandTotal += a.total;
    })
    return grandTotal;
  }

  removeCartItem(i: number) {
    this.cartItemList.splice(i, 1);
  }

  removeAllCart() {
    this.cartItemList = []
    this.productList.next(this.cartItemList);
  }

  IncreaseQuantity(product: any) {
    this.cartItemList.map((a: any, index: any) => {
      if (product.prodId === a.prodId) {
        this.quantity++;
      }
    })
  }
}
