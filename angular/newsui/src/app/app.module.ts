import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SignupComponent } from './signup/signup.component';
import { LoginComponent } from './login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { NewsComponent } from './news/news.component';
import { HeaderComponent } from './header/header.component';
import { SearchComponent } from './search/search.component';
import { FavouriteArticleComponent } from './favourite-article/favourite-article.component';
import { JwtInterceptor } from 'src/interceptor';
import { APP_BASE_HREF } from '@angular/common';

@NgModule({
  declarations: [
    AppComponent,
    SignupComponent,
    LoginComponent,
    NewsComponent,
    HeaderComponent,
    SearchComponent,
    FavouriteArticleComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule    
  ],
  providers: [{ provide: APP_BASE_HREF, useValue: '/' },
  { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true }
]
,
  bootstrap: [AppComponent]
})
export class AppModule { }
