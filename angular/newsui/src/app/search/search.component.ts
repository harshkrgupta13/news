import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SearchService } from '../search.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})


export class SearchComponent implements OnInit {

  constructor(private searchAnalyst: SearchService, private router: Router) { }
  analyst: any;
  isUser = false;

  ngOnInit() {
  }

  get(email) {
    this.searchAnalyst.search(email).subscribe(
      data => {
        if (data != null) {
          this.isUser = true;
          this.analyst = data;
        }


        console.log(this.analyst)
      }
    );
  }
  
  changeStatus(email) {
    this.searchAnalyst.status(email).subscribe(
      data => {
        this.analyst = data;
      }
    )

  }
}
