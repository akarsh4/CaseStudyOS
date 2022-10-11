import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { user } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class LoginRegisterService {

  constructor(private http: HttpClient) { }

  public loginUser(user: user): Observable<any> {
    return this.http.post<any>("http://localhost:8809/login", user)
  }

  public registerUser(user: user): Observable<any> {
    return this.http.post<any>("http://localhost:8809/register", user);
  }

  handleError(error: Response) { }

}
