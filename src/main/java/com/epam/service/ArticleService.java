package com.epam.service;

import com.epam.dto.ArticleWithoutContent;
import com.epam.entity.Article;

import java.util.List;

public interface ArticleService {
    List<Article> getAll();
    Article getById(long id);
    long save(Article article);
    void update(Article article);
    void deleteById(long id);
    void deleteByIds(List<String> ids);
    void update(ArticleWithoutContent articleWithoutContent);
}
