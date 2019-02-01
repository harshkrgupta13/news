import { Component, OnInit } from '@angular/core';
import { NewsApiService } from '../news-api.service';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.css']
})

export class NewsComponent implements OnInit {

  id: any;
  languageCode: any;
  articleList: any[];
  articles: any;
  favouriteArticle: any;
  favoriteArticleId: any;

  ngOnInit() {
    this.id = this.service.getUserId()
    console.log(this.id);
    this.newsApi.initSources().subscribe(data => {
      console.log(data)
      this.articleList = data.articles;
    })
  }

  constructor(private newsApi: NewsApiService, private service: AuthService) { }

  saveArticle(articleTitle) {
    this.articleList.forEach(favoriteArticle => {
      if (favoriteArticle.title == articleTitle) {
        console.log(favoriteArticle.title);
        let user = JSON.stringify({
          id: this.service.getUserId(),
          article: [favoriteArticle]
        })
        console.log(user);
        console.log(this.id);
        this.newsApi.saveArticle(user).subscribe(data => {
          this.favoriteArticleId = data;
          console.log(this.favoriteArticleId);
        })
      }
    });
  }

}
