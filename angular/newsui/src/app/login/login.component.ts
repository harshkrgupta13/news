import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/login.service';
import { NewsApiService } from '../news-api.service';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(public router: Router, public loginService: LoginService, 
  private newsApi: NewsApiService, private service: AuthService) { }

  languageCode: any;
  form = new FormGroup({
    email: new FormControl(
       '',
      [ Validators.required,
        Validators.pattern('^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$'),
        Validators.maxLength(255),
      ]
    ),
    password: new FormControl(
      '',
      [ Validators.required,
        Validators.minLength(6),
        Validators.maxLength(50)]
    )
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

        if (data.authenticated && data.user.blacklisted) {
          this.service.login();
          this.languageCode = data.user.language.languageCode;
          this.newsApi.languageCode = this.languageCode;
          this.service.setUserId(data.user.id);
          this.languageCode = this.service.setLanguageCode(this.languageCode);
          console.log(this.newsApi.languageCode)
          this.router.navigate(['/searchnews']);

        }
        if (data.admin) {
          this.router.navigate(['/search']);
        }

      },
    );
  }


}
