package com.epam.service.impl;

import com.epam.dao.ArticleDao;
import com.epam.dto.ArticleWithoutContent;
import com.epam.entity.Article;
import com.epam.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    private final ArticleDao articleDao;

    @Autowired
    public ArticleServiceImpl(ArticleDao articleDao) {
        this.articleDao = articleDao;

    }

    @Override
    public List<Article> getAll() {
        return articleDao.getAll();
    }

    @Override
    public Article getById(long id) {
        return articleDao.getById(id);
    }

    @Override
    public long save(Article article) {
        article.setId(0);
        return articleDao.save(article);
    }

    @Override
    public void update(Article article) {
        articleDao.update(article);
    }

    @Override
    public void deleteById(long id) {
        articleDao.deleteById(id);
    }

    @Override
    public void deleteByIds(List<String> ids) {
        articleDao.deleteByIds(ids);
    }

    @Override
    public void update(ArticleWithoutContent articleWithoutContent) {
        articleDao.update(articleWithoutContent);
    }
}
