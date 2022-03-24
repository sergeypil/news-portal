import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Article, ArticleService } from '../services/article.service';

@Component({
  selector: 'app-article-page',
  templateUrl: './article-page.component.html',
  styleUrls: ['./article-page.component.css']
})
export class ArticlePageComponent implements OnInit {

  id: string;
  article: any;
  isOpenConfirm = false;
  constructor(private articleService: ArticleService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.articleService.getArticleById(this.id).subscribe(data => {
      this.article = data;
      console.log("access");
    }, error =>
      console.log("error"))
  }

  editArticle() {

  }

  openConfirmMenu() {
    this.isOpenConfirm = true;
  }

  deleteArticle() {
    console.log("call delete")
    this.articleService.deleteArticleById(this.id).subscribe(data => {
      console.log("access");
      alert("Deleted successfully");
      this.router.navigate(['/admin/articles']);
    }, error =>
      console.log("error")
    );
  }
}
