import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

const httpOptions={
  headers: new HttpHeaders({
    'Content-Type':'application/json',
  })
}

@Injectable({
  providedIn: 'root'
})
export class NewsApiService {

  sourceUrl:string ="/news-service/saveSource";
  languageCode:any;
  api_key = 'd79b66b0efb047b3a10c93e87b6232a5';
  constructor(private http:HttpClient) { }
  initSources(){
     return this.http.get('https://newsapi.org/v2/sources?language='+this.languageCode+'&apiKey='+this.api_key);
  }
  getArticlesByID(source: String){
   return this.http.get('https://newsapi.org/v2/top-headlines?sources='+source+'&apiKey='+this.api_key);
  }
    saveArticle(source): Observable<any>{  
      return this.http.post<any>(this.sourceUrl,source,httpOptions);
  }

} 
