import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { SignupComponent } from './signup.component';
import { By, BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterTestingModule } from '@angular/router/testing';
import { DebugElement } from '@angular/core';
import { Routes } from '@angular/router';
import { SignupService } from '../signup.service';

fdescribe('SignupComponent', () => {
  let component: SignupComponent;
  let fixture: ComponentFixture<SignupComponent>;
  let de: DebugElement;
  let el: HTMLElement;


 beforeEach(async(() => {
    const routes: Routes = [
      { path : "signup", component: SignupComponent}
    ];
    TestBed.configureTestingModule({
      declarations: [SignupComponent],
      imports: [
        BrowserModule,
        FormsModule,
        ReactiveFormsModule,
        HttpClientModule,
        RouterTestingModule
      ],
      providers: [
        { provide: SignupService }
      ]
    })
      .compileComponents().then(() => {
        fixture = TestBed.createComponent(SignupComponent);
        component = fixture.componentInstance;

        de = fixture.debugElement.query(By.css('form'));
        el = de.nativeElement;

      });
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });

 it('form should valid when field is not empty', async(() => {
   component.form.controls['name'].setValue('harsh');
    component.form.controls['email'].setValue('harsh@gmail.com');
    component.form.controls['password'].setValue('harshg');
     component.form.controls['language'].setValue('English');
    expect(component.form.valid).toBeTruthy();
  }));

   it('form should invalid when empty', async(() => {
    component.form.controls['name'].setValue('');
    component.form.controls['email'].setValue('');
    component.form.controls['password'].setValue('');
     component.form.controls['language'].setValue('');
    expect(component.form.valid).toBeFalsy();
  }));

   it('form invalid when email pattern is wrong ', async(() => {
    component.form.controls['email'].setValue('harsh');
    expect(component.form.valid).toBeFalsy();
    expect(component.form.controls['email'].valid).toBeFalsy();
  }));

  it('form invalid when password character less than 6', async(() => {
    component.form.controls['password'].setValue('harsh');
    expect(component.form.valid).toBeFalsy();
    expect(component.form.controls['password'].valid).toBeFalsy();
  }));

   it('is form invalid when password character more than 50', async(() => {
    component.form.controls['password'].setValue('xfhszdgsdzgdgsdfdsdgbsdzgsgsdgdvsdgvdgvdgdgvdgvdgvbdgvbdsdfsadfsafdsffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff');
    expect(component.form.valid).toBeFalsy();
    expect(component.form.controls['password'].valid).toBeFalsy();
  }));

});
