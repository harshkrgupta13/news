import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { LoginComponent } from './login.component';
import { DebugElement } from '@angular/core';
import { Routes } from '@angular/router';
import { By, BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LoginService } from '../login.service';
import { HttpClientModule } from '@angular/common/http';
import { NewsApiService } from '../news-api.service';
import { RouterTestingModule } from '@angular/router/testing';
import { SignupComponent } from '../signup/signup.component';

fdescribe('LoginComponent', () => {
  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;
  let de: DebugElement;
  let el: HTMLElement;

  beforeEach(async(() => {
    const routes: Routes = [
      { path: "", component: LoginComponent },
      { path: "login", component: LoginComponent },
      { path : "signup", component: SignupComponent}
    ];
    TestBed.configureTestingModule({
      declarations: [LoginComponent],
      imports: [
        BrowserModule,
        FormsModule,
        ReactiveFormsModule,
        HttpClientModule,
        RouterTestingModule
      ],
      providers: [
        { provide: LoginService }
      ]
    })
      .compileComponents().then(() => {
        fixture = TestBed.createComponent(LoginComponent);
        component = fixture.componentInstance;

        de = fixture.debugElement.query(By.css('form'));
        el = de.nativeElement;

      });
  }));


  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('form should valid when field is not empty', async(() => {
    //accessing controls
    component.form.controls['email'].setValue('harsh@gmail.com');
    component.form.controls['password'].setValue('harshg');
    expect(component.form.valid).toBeTruthy();
  }));
  it('form should invalid when empty', async(() => {
    //accessing controls
    component.form.controls['email'].setValue('');
    component.form.controls['password'].setValue('');
    expect(component.form.valid).toBeFalsy();
  }));

  it('form invalid when email pattern is wrong ', async(() => {
    component.form.controls['email'].setValue('harsh');
    expect(component.form.valid).toBeFalsy();
    expect(component.form.controls['email'].valid).toBeFalsy();
  }));

  it('form invalid when password character less than 6', async(() => {
    component.form.controls['password'].setValue('Harsh');
    expect(component.form.valid).toBeFalsy();
    expect(component.form.controls['password'].valid).toBeFalsy();
  }));

  it('is form invalid when password character more than 50', async(() => {
    component.form.controls['password'].setValue('xfhszdgsdzgdgsdfdsdgbsdzgsgsdgdvsdgvdgvdgdgvdgvdgvbdgvbdsdfsadfsafdsffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff');
    expect(component.form.valid).toBeFalsy();
    expect(component.form.controls['password'].valid).toBeFalsy();
  }));

  it('should call the login method', async(() => {
    fixture.detectChanges();
    spyOn(component, 'check');
    el = fixture.debugElement.query(By.css('button')).nativeElement;
    el.click();
    expect(component.check).toHaveBeenCalledTimes(1);
  }));
});
