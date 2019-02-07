import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  languageCode: any;
  loggedIn: boolean;
  id: any;
  token: any;

  constructor() { }

  login() {
    console.log("Inside auth service login()");
    this.loggedIn = true;
  }
  getToken() {
    return this.token;
  }
  setToken(token : string) {
    this.token = token;
  }
  logout() {
    console.log("Inside auth service logout()");
    this.loggedIn = false;
  }

  getLanguageCode() {
    return this.languageCode;
  }

  setLanguageCode(languageCode: string) {
    this.languageCode = languageCode;
  }

  getUserId() {
    return this.id;
  }

  setUserId(id: number) {
    this.id = id;
  }

}
