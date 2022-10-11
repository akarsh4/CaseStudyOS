import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from '../models/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  setObject(product: Observable<Product[]>) {
    throw new Error('Method not implemented.');
  }
  private baseUrl = 'http://localhost:8803/products';
  private addProductUrl = 'http://localhost:8080/add/product'

  constructor(private http: HttpClient) { }

  getProductsList() : Observable<Product[]>{
    return this.http.get<Product[]>(this.baseUrl);
  }
  
  getProductDetailsByID(id: number): Observable<any> {
    return this.http.get(`http://localhost:8803/products/` + id) 
  }

  //getCategoryList(): Observable<any> {
  //  return this.http.get(`${this.categoryUrl}`);
  //}

  addProduct(product: Object):Observable<Object> {
    return this.http.post(`${this.addProductUrl}`, product);
  }

}
