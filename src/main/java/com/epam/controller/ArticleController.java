package com.epam.controller;

import com.epam.dto.ArticleWithoutContent;
import com.epam.dto.DeleteIdsRequest;
import com.epam.entity.Article;
import com.epam.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public List<Article> getAllArticles() {
        List<Article> articles = articleService.getAll();
        return articles;
    }

    @GetMapping("/{id}")
    public Article getArticleById(@PathVariable int id) {
        Article article = articleService.getById(id);
        return article;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<?> createArticle(@Valid @RequestBody Article article, BindingResult result) {
        if (result.hasErrors()) {
            String errorMessages = result.getFieldErrors().stream()
                    .map(err -> err.getDefaultMessage())
                    .reduce("",(subtotal, err) -> subtotal + "\n" + err);
            return new ResponseEntity<>(errorMessages, HttpStatus.BAD_REQUEST);
        }
        articleService.save(article);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping
    public ResponseEntity<?> updateArticle(@Valid @RequestBody Article article, BindingResult result) {
        if (result.hasErrors()) {
            String errorMessages = result.getFieldErrors().stream()
                    .map(err -> err.getDefaultMessage())
                    .reduce("",(subtotal, err) -> subtotal + "\n" + err);
            return new ResponseEntity<>(errorMessages, HttpStatus.BAD_REQUEST);
        }
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
        articleService.deleteByIds(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping
    public ResponseEntity<?> updateArticle(@Valid @RequestBody ArticleWithoutContent articleWithoutContent, BindingResult result) {
        if (result.hasErrors()) {
            String errorMessages = result.getFieldErrors().stream()
                    .map(err -> err.getDefaultMessage())
                    .reduce("",(subtotal, err) -> subtotal + "\n" + err);
            return new ResponseEntity<>(errorMessages, HttpStatus.BAD_REQUEST);
        }
        articleService.update(articleWithoutContent);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
