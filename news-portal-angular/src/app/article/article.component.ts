import { Component, Input, OnInit } from '@angular/core';
import { Article } from '../services/article.service';

@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.css']
})
export class ArticleComponent {
  @Input() articleItem: Article;

}
