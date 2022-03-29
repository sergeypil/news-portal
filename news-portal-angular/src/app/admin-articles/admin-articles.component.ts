import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { ArticleService } from '../services/article.service';

@Component({
  selector: 'app-admin-articles',
  templateUrl: './admin-articles.component.html',
  styleUrls: ['./admin-articles.component.css']
})
export class AdminArticlesComponent implements OnInit {

  constructor(private articleService: ArticleService, private router: Router) { }
  articles: any;
  isOpenConfirm = false;

  ngOnInit(): void {
    this.get();
  }

  get() {
    this.articleService.getArticles().subscribe((data) => {
      this.articles = data;
      console.log(data);
      console.log("access")
      this.articles = this.articles.map((obj: any) => ({ ...obj, checked: false }));
      //this.articles = this.articles.sort((a: any, b: any) => (a.created < b.created) ? 1 : ((b.create < a.created) ? -1 : 0));
      this.articles = this.articles.sort((a: any, b: any) => b.created - a.created);
    })
  }

  openConfirmMenu(form: NgForm) {
    const articles = this.articles.filter((el: { checked: boolean; }) => el.checked == true);
    if (articles.length == 0) {
      alert("Select article at first");
    }
    else {
      this.isOpenConfirm = true;
      console.log(this.articles);
    }
  }

  deleteArticles() {
    console.log("call delete")
    // console.log(this.articles.filter((el: { checked: boolean; }) => el.checked == true));
    // this.articles.filter((el: { checked: boolean; }) => el.checked == true).forEach((el: any) => {
    //   this.articleService.deleteArticleById(el.id).subscribe(data => {
    //     console.log("access");
    //     this.router.navigate(['/admin/articles']);
    //   }, error =>
    //     console.log("error")
    //   );
    // });
    const articles = this.articles.filter((el: { checked: boolean; }) => el.checked == true);
    const ids = articles.map((el: { id: any; }) => el.id);
    console.log(ids);
    this.articleService.deleteSeveralArticlesById(ids)
      .subscribe(data => {
        alert("Deleted successfully");
        window.location.reload();
      })
  }
}

