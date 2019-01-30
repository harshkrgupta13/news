import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SearchService } from '../search.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})


export class SearchComponent implements OnInit {

  constructor(private analyst:SearchService, private router: Router) { }
analyst1:any;
isUser=false;
analyst2:any;

  ngOnInit() {
  }
  get(email){
    this.analyst.search(email).subscribe(
      data => {
        if(data!=null){
         this.isUser=true;
          this.analyst1=data;
        }
 
    
        console.log(this.analyst1)
      }
    );
  }
  changeStatus(email){
    this.analyst.status(email).subscribe(
      data=>{
        this.analyst1=data;
      }
    )

  }
}
