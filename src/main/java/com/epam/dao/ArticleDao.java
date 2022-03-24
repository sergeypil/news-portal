package com.epam.dao;

import com.epam.entity.Article;

import java.util.List;

public interface ArticleDao {
    List<Article> getAllArticles();
    Article getArticleById(long id);
    void save(Article article);
    void update(Article article);
    void deleteById(long id);
}
