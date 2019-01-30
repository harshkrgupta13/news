import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  languageCode:any;
  loggedIn :  boolean = false;
  constructor() { }

  login() {
    console.log("Inside auth service login()");
    this.loggedIn = true;
  }

  logout() {
    console.log("Inside auth service logout()");
    this.loggedIn = false;
  }
    
  getLanguageCode(){
    return  this.languageCode;
   }
 
   setLanguageCode(languageCode:string){
       this.languageCode=languageCode;
    }
}
