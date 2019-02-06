import { TestBed, async } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { AppComponent } from './app.component';
import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { APP_BASE_HREF } from '@angular/common';
import { NewsComponent } from './news/news.component';
import { SignupComponent } from './signup/signup.component';
import { SearchComponent } from './search/search.component';
import { HeaderComponent } from './header/header.component';
import { FavouriteArticleComponent } from './favourite-article/favourite-article.component';

fdescribe('AppComponent', () => {

  const routes: Routes = [
    { path: "", component: LoginComponent },
    { path: "login", component: LoginComponent },
    { path: "signup", component: SignupComponent },
    { path: "searchnews", component: NewsComponent },
    { path: "search", component: SearchComponent },
    { path: "favourite", component: FavouriteArticleComponent }

  ];

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [
        ReactiveFormsModule,
        FormsModule,
        AppRoutingModule,
        RouterTestingModule
      ],
      declarations: [
        AppComponent,
        SignupComponent,
        LoginComponent,
        NewsComponent,
        HeaderComponent,
        SearchComponent,
        FavouriteArticleComponent
      ],
      providers: [
        { provide: APP_BASE_HREF, USE_VALUE: '/' }
      ]
    }).compileComponents();
  }));

  it('should create the app', () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app).toBeTruthy();
  });

  it(`should have as title 'newsui'`, () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.title).toEqual('newsui');
  });

 /* it('should render title in a h1 tag', () => {
    const fixture = TestBed.createComponent(AppComponent);
    fixture.detectChanges();
    const compiled = fixture.debugElement.nativeElement;
    expect(compiled.querySelector('h1').textContent).toContain('Welcome to newsui!');
  });*/
});
