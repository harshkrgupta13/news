import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { SignupService } from '../signup.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {


  languages:any;
  email:any;
  password:any;
  language:any;
  name:any;
  constructor(private signupService: SignupService) { }


  form = new FormGroup({
    name: new FormControl,
    email: new FormControl,
    password: new FormControl,
   language: new FormControl()
 })

  ngOnInit() {
     this.signupService.getLanguage().subscribe(
      data => {
        this.languages = data;
        console.log(this.languages)
      },
    );
  }
message=false;
status:any
  signup(){
    console.log(this.form.value);
     this.signupService.signup(JSON.stringify({
      email: this.form.value.email,
      name: this.form.value.name,
      password: this.form.value.password,
      userLanguage: {
        languageId: this.form.controls['language'].value
      }
    })).subscribe(
    data=> {
      this.status=data;
      console.log(data);
   console.log("sucess");
    this.message=true;
  } )
 
   this.form.reset();

  }
}