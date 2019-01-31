import { Component, OnInit } from '@angular/core';
import { NewsApiService } from '../news-api.service';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-favourite-article',
  templateUrl: './favourite-article.component.html',
  styleUrls: ['./favourite-article.component.css']
})
export class FavouriteArticleComponent implements OnInit {

  constructor(private newsApi : NewsApiService, private  authService:AuthService) { }

  favouriteArticle: any;
  id: any;

  ngOnInit() {
    this.id = this.authService.getUserId();
    this.newsApi.getUser(this.id).subscribe(data => {
      this.favouriteArticle = data.article;
      console.log(data);
      console.log(this.favouriteArticle);


    })
  }






}
