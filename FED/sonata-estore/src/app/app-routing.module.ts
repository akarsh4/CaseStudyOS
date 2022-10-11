import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './components/about/about.component';
import { CartComponent } from './components/cart/cart.component';
import { ContactComponent } from './components/contact/contact.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { OrderComponent } from './components/order/order.component';
import { OrdersuccessComponent } from './components/ordersuccess/ordersuccess.component';
import { ProductDetailsComponent } from './components/product-details/product-details.component';
import { ProfileComponent } from './components/profile/profile.component';
import { RegisterComponent } from './components/register/register.component';

const routes: Routes = [
  {path: '', redirectTo: 'login', pathMatch: 'full'},
  {path : 'login', component : LoginComponent},
  {path : 'register', component : RegisterComponent},
  {path : 'home', component : HomeComponent},
  {path : 'about', component : AboutComponent},
  {path : 'contact', component : ContactComponent},
  {path : 'cart', component : CartComponent},
  {path : 'product-details', component : ProductDetailsComponent},
  {path : 'profile', component : ProfileComponent},
  {path : 'order', component : OrderComponent},
  {path : 'ordersuccess', component : OrdersuccessComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
