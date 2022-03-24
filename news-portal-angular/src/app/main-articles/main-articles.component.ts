import { Component, OnInit } from '@angular/core';
import { ArticleService, Article } from '../services/article.service';

@Component({
  selector: 'app-main-articles',
  templateUrl: './main-articles.component.html',
  styleUrls: ['./main-articles.component.css']
})
export class MainArticlesComponent implements OnInit {

  constructor(private articleService: ArticleService) { }
  articles: any;

  ngOnInit(): void {
    this.get();
  }

  get() {
    this.articleService.getArticles().subscribe((data => {
      this.articleService.articles = data;
      this.articles = data;
      console.log(data);
      console.log("acsess");
    }))
  }
}
