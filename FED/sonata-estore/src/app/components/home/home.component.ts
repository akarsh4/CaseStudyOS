import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/models/product';
import { ProductService } from 'src/app/services/product.service';
import { CartService } from 'src/app/services/cart.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})

export class HomeComponent implements OnInit {

  public product!: Product[];

  constructor(
    private productService: ProductService,
    private cartService: CartService
    ) { }

  ngOnInit(): void {
    this.reloadData();
  }

  reloadData() {
    this.productService.getProductsList()
      .subscribe(data => this.product = data)
  }

  addToCart(product: Product) {
    this.cartService.addtoCart(product);
    //alert('Your product has been added to the cart!');
  }

}
