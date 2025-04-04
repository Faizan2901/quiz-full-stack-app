import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  
  private apiUrl = 'http://localhost:8080/api/auth';

  http=inject(HttpClient);

  register(user:any):Observable<any>{
    return this.http.post(`${this.apiUrl}/register`,user,{responseType : 'text'});
  }

  login(credentials:any):Observable<string>{
    return this.http.post(`${this.apiUrl}/login`,credentials,{responseType : 'text'});
  }

  saveToken(token:string){
    localStorage.setItem("authToken",token);
  }

  getToken():string | null{
    return localStorage.getItem("authToken");
  }

  logout(){
    localStorage.removeItem("authToken");
  }

  isAuthenticated():boolean{
    return !!localStorage.getItem('authToken');
  }


}
