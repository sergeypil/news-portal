package com.epam.service;

import com.epam.entity.Article;

import java.util.List;

public interface ArticleService {
    List<Article> getAllArticles();
    Article getArticleById(long id);
    void save(Article article);
    void update(Article article);
    void deleteById(long id);
    void deleteBySeveralIds(List<String> ids);
}
