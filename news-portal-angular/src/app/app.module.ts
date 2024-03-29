import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClient, HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ArticlesComponent } from './articles/articles.component';
import { ArticleComponent } from './article/article.component';
import { ArticleService } from './services/article.service';
import { AddArticleComponent } from './add-article/add-article.component';
import { HomeComponent } from './home/home.component';
import { NavbarComponent } from './navbar/navbar.component';
import { LoginFormComponent } from './login-form/login-form.component';
import { AsideArticlesComponent } from './aside-articles/aside-articles.component';
import { MainArticlesComponent } from './main-articles/main-articles.component';
import { AdminPageComponent } from './admin-page/admin-page.component';
import { AdminArticlesComponent } from './admin-articles/admin-articles.component';
import { FormsModule } from '@angular/forms';
import { ArticlePageComponent } from './article-page/article-page.component';
import { AuthService } from './services/auth.service';
import { TranslateModule, TranslateLoader } from '@ngx-translate/core';
import { TranslateHttpLoader } from '@ngx-translate/http-loader';

export function HttpLoaderFactory(http: HttpClient) {
  return new TranslateHttpLoader(http, './assets/i18n/', '.json');
}

@NgModule({
  declarations: [
    AppComponent,
    ArticlesComponent,
    ArticleComponent,
    AddArticleComponent,
    HomeComponent,
    NavbarComponent,
    LoginFormComponent,
    AsideArticlesComponent,
    MainArticlesComponent,
    AdminPageComponent,
    AdminArticlesComponent,
    ArticlePageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    TranslateModule.forRoot({
      defaultLanguage: 'en-US',
      loader: {
        provide: TranslateLoader,
        useFactory: HttpLoaderFactory,
        deps: [HttpClient]
      }
    }
    )
  ],
  providers: [ArticleService, AuthService],
  bootstrap: [AppComponent]
})
export class AppModule { }
