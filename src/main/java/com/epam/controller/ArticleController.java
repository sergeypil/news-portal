package com.epam.controller;

import com.epam.entity.Article;
import com.epam.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/newapi/articles")
@RestController
@CrossOrigin("*")
public class ArticleController {
    ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    List<Article> getAllArticles() {
        List<Article> articles = articleService.getAllArticles();
        return articles;
    }

    @GetMapping("/{id}")
    Article getArticleById(@PathVariable int id) {
        Article article = articleService.getArticleById(id);
        return article;
    }

    @PostMapping
    public ResponseEntity<Void> createArticle(@RequestBody Article article) {
        articleService.save(article);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void> updateArticle(@RequestBody Article article) {
        articleService.update(article);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticleById(@PathVariable long id) {
        articleService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
