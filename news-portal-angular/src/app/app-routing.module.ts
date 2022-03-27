import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddArticleComponent } from './add-article/add-article.component';
import { AdminArticlesComponent } from './admin-articles/admin-articles.component';
import { AdminPageComponent } from './admin-page/admin-page.component';
import { ArticlePageComponent } from './article-page/article-page.component';
import { HomeComponent } from './home/home.component';
import { LoginFormComponent } from './login-form/login-form.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  {
    path: 'admin', component: AdminPageComponent, children: [
      { path: 'articles', component: AdminArticlesComponent },
      { path: 'new-article', component: AddArticleComponent },
      { path: 'new-article/:id', component: AddArticleComponent }
    ]
  },
  { path: 'article/:id', component: ArticlePageComponent },
  { path: 'login', component: LoginFormComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
