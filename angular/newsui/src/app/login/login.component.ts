import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/login.service';
import { NewsApiService } from '../news-api.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(public router: Router, public loginService: LoginService, private newsApi: NewsApiService) { }

  languageCode: any;
  form = new FormGroup({
    email: new FormControl(),
    password: new FormControl()
  });


  ngOnInit() {
  }

  check(email: string, password: string) {
    console.log("Inside check() function");
    let json = JSON.stringify({
      email: email,
      password: password
    });
    console.log(json);
    this.loginService.authenticateUser(json)
      .subscribe(data => {
        console.log("incoming Data: " + data)
        console.log("incoming Data: " + data.user.language.languageCode)
        console.log("incoming Data: " + data.authenticated)
        console.log("incoming admin or not? : " + data.admin)


        if (data.authenticated) {
          this.languageCode = data.user.language.languageCode;
          this.newsApi.languageCode = this.languageCode;
          console.log(this.newsApi.languageCode)
          this.router.navigate(['/searchnews']);

        }

      },
    );
  }


}
