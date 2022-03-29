package com.epam.controller;

import com.epam.dao.impl.ArticleDaoImpl;
import com.epam.dto.DeleteIdsRequest;
import com.epam.entity.Article;
import com.epam.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequestMapping("/newapi/articles")
@RestController
@CrossOrigin("*")
public class ArticleController {
    private final ArticleService articleService;

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

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Void> createArticle(@RequestBody Article article) {
        articleService.save(article);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping
    public ResponseEntity<Void> updateArticle(@RequestBody Article article) {
        articleService.update(article);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticleById(@PathVariable long id) {
        articleService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/ids")
    public ResponseEntity<Void> deleteArticlesByIds(@RequestBody DeleteIdsRequest deleteIdsRequest) {
        List<String> ids = deleteIdsRequest.getIds();
        articleService.deleteBySeveralIds(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
