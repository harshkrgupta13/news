import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthService } from './auth.service';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
  })
}

@Injectable({
  providedIn: 'root'
})
export class NewsApiService {

  savefavoriteArticleUrl = "/news-service/user/saveArticle"
  getUserUrl = "/news-service/user/user/"
  deletefavoriteArticleUrl = "/news-service/user/delete"

  languageCode: any;
  code: any;

  api_key = 'd79b66b0efb047b3a10c93e87b6232a5';

  constructor(private http: HttpClient, private service: AuthService) { }

  getArticles(): Observable<any> {
    this.code = this.service.getLanguageCode();
    return this.http.get('https://newsapi.org/v2/top-headlines?language=' + this.code + '&apiKey=' + this.api_key);
  }


  saveArticle(favoriteArticle) {
    console.log("inside save article service")
    return this.http.post(this.savefavoriteArticleUrl, favoriteArticle, httpOptions)

  }

  getUser(id): Observable<any> {
    console.log(id);
    return this.http.get(this.getUserUrl + id);
  }

  deleteArticle(favoriteArticle) {
    console.log("inside delete article service")
    return this.http.post(this.deletefavoriteArticleUrl, favoriteArticle, httpOptions)

  }

   searchArticles(keyword) {
    return this.http.get("https://newsapi.org/v2/everything?q=" + keyword + "&apiKey=" + this.api_key);

  }


} 
