import { Component, OnInit } from '@angular/core';
import { NewsApiService } from '../news-api.service';
import { LoginComponent } from '../login/login.component';



@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.css']
})
export class NewsComponent implements OnInit {

  Articles:any[];
  Sources:any[];
  ngOnInit() {
    
    //load news sources
    this.newsApi.initSources().subscribe(
      data=> this.Sources = data['sources']
    );  
  }
  constructor(private newsApi: NewsApiService) {}
 
  searchArticles(source){
    console.log("selected source is: "+source);
    this.newsApi.getArticlesByID(source)
    .subscribe(
      data =>
       this.Articles = data['articles']
    );
  }
  saveArticle(source){
    console.log("selected source is: "+source);
    this.newsApi.saveArticle(source);
  }


}
