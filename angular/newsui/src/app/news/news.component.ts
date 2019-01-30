import { Component, OnInit } from '@angular/core';
import { NewsApiService } from '../news-api.service';
import { LoginComponent } from '../login/login.component';

@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.css']
})

export class NewsComponent implements OnInit {

languageCode:any;
 articleList: any[];
  articles: any;
favouriteArticle: any;
 
  ngOnInit() {
      this.newsApi.initSources().subscribe(data => {
      console.log(data)
      this.articleList = data.articles;
    })
  }
  
  constructor(private newsApi: NewsApiService) {}

  saveArticle(articleTitle) {
    //console.log(articleTitle);
    this.articleList.forEach(favouriteArticle => {

      // console.log(element.title);
      if (favouriteArticle.title == articleTitle) {
        console.log(favouriteArticle.title);
        // console.log(favoriteArticle)

        this.newsApi.saveArticle(favouriteArticle).subscribe(data => {
          this.favouriteArticle = data;
          console.log(this.favouriteArticle);
        })
      }});
 }
 
}
