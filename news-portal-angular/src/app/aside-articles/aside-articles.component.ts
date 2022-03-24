import { Component, OnInit } from '@angular/core';
import { ArticleService, Article } from '../services/article.service';

@Component({
  selector: 'app-aside-articles',
  templateUrl: './aside-articles.component.html',
  styleUrls: ['./aside-articles.component.css']
})
export class AsideArticlesComponent {

  constructor(private articleService: ArticleService) { }
  articles: any;

  ngOnInit(): void {
    this.get();
  }

  get() {
    this.articleService.getArticles().subscribe((data) => {
      this.articles = data;
      console.log(data);
      console.log("acsess")
    })
  }
}
