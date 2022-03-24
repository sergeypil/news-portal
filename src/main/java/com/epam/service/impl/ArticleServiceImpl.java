package com.epam.service.impl;

import com.epam.dao.ArticleDao;
import com.epam.entity.Article;
import com.epam.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public class ArticleServiceImpl implements ArticleService {
    ArticleDao articleDao;

    public ArticleServiceImpl(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    public ArticleServiceImpl() {

    }


    @Override
    public List<Article> getAllArticles() {
        return articleDao.getAllArticles();
    }

    @Override
    public Article getArticleById(long id) {
        return articleDao.getArticleById(id);
    }

    @Override
    public void save(Article article) {
        articleDao.save(article);
    }

    @Override
    public void update(Article article) {
        articleDao.save(article);
    }

    @Override
    public void deleteById(long id) {
        articleDao.deleteById(id);
    }
}
