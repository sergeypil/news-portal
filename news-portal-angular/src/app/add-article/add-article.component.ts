import { Component, OnInit } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ArticleService, Article } from '../services/article.service';

@Component({
  selector: 'app-add-article',
  templateUrl: './add-article.component.html',
  styleUrls: ['./add-article.component.css']
})
export class AddArticleComponent implements OnInit {
  id: string;
  isAddMode: boolean;
  article: any;
  defaultDate = new Date();
  constructor(private articleService: ArticleService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.isAddMode = !this.id;
    if (this.id) {
      this.articleService.getArticleById(this.id).subscribe(data => {
        this.article = data;
        console.log("access");
      }, error =>
        console.log("error"))
    }
    else {
      this.article = {
        id: '',
        title: '',
        brief: '',
        content: '',
        created: new Date()
      }
    }
  }


  createArticle(form: NgForm) {
    console.log("form")
    console.log(form)
    console.log(form.value["title"])
    const newArticle: Article = {
      id: +this.id,
      title: form.value["title"],
      brief: form.value["brief"],
      content: form.value["content"],
      created: form.value["date"]
    };
    if (this.isAddMode) {
      console.log(this.article)
      this.articleService.create(newArticle).subscribe(data => {
        console.log("add");
        alert("Saved successfully!");
        this.router.navigate(['/admin/articles']);
      })

    }
    else {
      this.articleService.editArticleById(newArticle).subscribe(data =>
        console.log("edit"));
      alert("Saved successfully!");
      this.router.navigate(['/admin/articles']);
    }
  }

}
