import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable} from 'rxjs';


const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
  })
};

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  url : string="/news-service/authenticate"

  constructor(private http: HttpClient) { }

  authenticateUser(json): Observable<any> {
    console.log("in addUser()" + json);
    return this.http.post<any>(this.url, json, httpOptions);
  }
}