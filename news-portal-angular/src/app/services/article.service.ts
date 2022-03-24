import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Article {
  id: number;
  title: string;
  brief: string;
  content: string;
  created: Date
}


@Injectable()
export class ArticleService {

  constructor(private httpClient: HttpClient) { }
  articles: any = [
    {
      id: 1,
      title: "win",
      brief: `briiiief briiiief briiiief briiiief briiiief briiiief briiiief briiiief briiiiefbriiiief briiiief briiiief 
            briiiief briiiief briiiiefbriiiief briiiief briiiief briiiief briiiief briiiief 
            briiiief briiiief briiiief briiiief briiiief briiiiefbriiiief briiiief briiiief briiiief briiiief briiiief`,
      content: `conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent 
          conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent 
          conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent 
          conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent 
          conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent `,
      created: new Date("2021-01-05")
    },
    {
      id: 2,
      title: "lose",
      brief: `briiiief briiiief briiiief briiiief briiiief briiiief briiiief briiiief briiiiefbriiiief briiiief briiiief 
            briiiief briiiief briiiiefbriiiief briiiief briiiief briiiief briiiief briiiief 
            briiiief briiiief briiiief briiiief briiiief briiiiefbriiiief briiiief briiiief briiiief briiiief briiiief`,
      content: `conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent 
          conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent 
          conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent 
          conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent 
          conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent `,
      created: new Date("2021-01-05")
    },
    {
      id: 3,
      title: "champ",
      brief: `briiiief briiiief briiiief briiiief briiiief briiiief briiiief briiiief briiiiefbriiiief briiiief briiiief 
            briiiief briiiief briiiiefbriiiief briiiief briiiief briiiief briiiief briiiief 
            briiiief briiiief briiiief briiiief briiiief briiiiefbriiiief briiiief briiiief briiiief briiiief briiiief`,
      content: `conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent 
          conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent 
          conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent 
          conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent 
          conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent `,
      created: new Date("2021-01-05")
    },
    {
      id: 1,
      title: "win",
      brief: `briiiief briiiief briiiief briiiief briiiief briiiief briiiief briiiief briiiiefbriiiief briiiief briiiief 
            briiiief briiiief briiiiefbriiiief briiiief briiiief briiiief briiiief briiiief 
            briiiief briiiief briiiief briiiief briiiief briiiiefbriiiief briiiief briiiief briiiief briiiief briiiief`,
      content: `conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent 
          conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent 
          conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent 
          conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent 
          conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent `,
      created: new Date("2021-01-05")
    },
    {
      id: 2,
      title: "lose",
      brief: `briiiief briiiief briiiief briiiief briiiief briiiief briiiief briiiief briiiiefbriiiief briiiief briiiief 
            briiiief briiiief briiiiefbriiiief briiiief briiiief briiiief briiiief briiiief 
            briiiief briiiief briiiief briiiief briiiief briiiiefbriiiief briiiief briiiief briiiief briiiief briiiief`,
      content: `conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent 
          conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent 
          conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent 
          conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent 
          conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent `,
      created: new Date("2021-01-05")
    },
    {
      id: 3,
      title: "champ",
      brief: `briiiief briiiief briiiief briiiief briiiief briiiief briiiief briiiief briiiiefbriiiief briiiief briiiief 
            briiiief briiiief briiiiefbriiiief briiiief briiiief briiiief briiiief briiiief 
            briiiief briiiief briiiief briiiief briiiief briiiiefbriiiief briiiief briiiief briiiief briiiief briiiief`,
      content: `conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent 
          conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent 
          conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent 
          conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent 
          conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent `,
      created: new Date("2021-01-05")
    },
    {
      id: 1,
      title: "win",
      brief: `briiiief briiiief briiiief briiiief briiiief briiiief briiiief briiiief briiiiefbriiiief briiiief briiiief 
            briiiief briiiief briiiiefbriiiief briiiief briiiief briiiief briiiief briiiief 
            briiiief briiiief briiiief briiiief briiiief briiiiefbriiiief briiiief briiiief briiiief briiiief briiiief`,
      content: `conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent 
          conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent 
          conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent 
          conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent 
          conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent `,
      created: new Date("2021-01-05")
    },
    {
      id: 2,
      title: "lose",
      brief: `briiiief briiiief briiiief briiiief briiiief briiiief briiiief briiiief briiiiefbriiiief briiiief briiiief 
            briiiief briiiief briiiiefbriiiief briiiief briiiief briiiief briiiief briiiief 
            briiiief briiiief briiiief briiiief briiiief briiiiefbriiiief briiiief briiiief briiiief briiiief briiiief`,
      content: `conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent 
          conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent 
          conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent 
          conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent 
          conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent `,
      created: new Date("2021-01-05")
    },
    {
      id: 3,
      title: "champ",
      brief: `briiiief briiiief briiiief briiiief briiiief briiiief briiiief briiiief briiiiefbriiiief briiiief briiiief 
            briiiief briiiief briiiiefbriiiief briiiief briiiief briiiief briiiief briiiief 
            briiiief briiiief briiiief briiiief briiiief briiiiefbriiiief briiiief briiiief briiiief briiiief briiiief`,
      content: `conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent 
          conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent 
          conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent 
          conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent 
          conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent `,
      created: new Date("2021-01-05")
    },
    {
      id: 1,
      title: "win",
      brief: `briiiief briiiief briiiief briiiief briiiief briiiief briiiief briiiief briiiiefbriiiief briiiief briiiief 
            briiiief briiiief briiiiefbriiiief briiiief briiiief briiiief briiiief briiiief 
            briiiief briiiief briiiief briiiief briiiief briiiiefbriiiief briiiief briiiief briiiief briiiief briiiief`,
      content: `conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent 
          conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent 
          conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent 
          conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent 
          conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent `,
      created: new Date("2021-01-05")
    },
    {
      id: 5,
      title: "lose",
      brief: `briiiief briiiief briiiief briiiief briiiief briiiief briiiief briiiief briiiiefbriiiief briiiief briiiief 
            briiiief briiiief briiiiefbriiiief briiiief briiiief briiiief briiiief briiiief 
            briiiief briiiief briiiief briiiief briiiief briiiiefbriiiief briiiief briiiief briiiief briiiief briiiief`,
      content: `conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent 
          conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent 
          conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent 
          conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent 
          conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent `,
      created: new Date("2021-01-05")
    },
    {
      id: 3,
      title: "champ",
      brief: `briiiief briiiief briiiief briiiief briiiief briiiief briiiief briiiief briiiiefbriiiief briiiief briiiief 
            briiiief briiiief briiiiefbriiiief briiiief briiiief briiiief briiiief briiiief 
            briiiief briiiief briiiief briiiief briiiief briiiiefbriiiief briiiief briiiief briiiief briiiief briiiief`,
      content: `conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent 
          conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent 
          conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent 
          conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent 
          conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent conteeeent `,
      created: new Date("2021-01-05")
    }
  ]


  public create(article: Article) {
    return this.httpClient.post("http://localhost:8080/news_portal_war/newapi/articles", article);
  }

  getArticles() {
    return this.httpClient.get("http://localhost:8080/news_portal_war/newapi/articles");
  }

  getArticleById(id: String) {
    return this.httpClient.get("http://localhost:8080/news_portal_war/newapi/articles/" + id);
  }

  editArticleById(article: Article) {
    return this.httpClient.put("http://localhost:8080/news_portal_war/newapi/articles/", article);
  }

  deleteArticleById(id: String) {
    return this.httpClient.delete("http://localhost:8080/news_portal_war/newapi/articles/" + id);
  }

}