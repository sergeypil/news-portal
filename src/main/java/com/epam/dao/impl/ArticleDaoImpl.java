package com.epam.dao.impl;

import com.epam.dao.ArticleDao;
import com.epam.entity.Article;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class ArticleDaoImpl implements ArticleDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public ArticleDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    @Override
    public List<Article> getAllArticles() {
        Session session = sessionFactory.getCurrentSession();
        Query<Article> query = session.createQuery("from Article", Article.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public Article getArticleById(long id) {
        Session session = sessionFactory.getCurrentSession();
        Article article = session.get(Article.class, id);
        return article;
    }

    @Transactional
    @Override
    public void save(Article article) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(article);
    }

    @Transactional
    @Override
    public void update(Article article) {
        Session session = sessionFactory.getCurrentSession();
        session.update(article);
    }

    @Transactional
    @Override
    public void deleteById(long id) {
        Session session = sessionFactory.getCurrentSession();
        Article article = session.get(Article.class, id);
        session.delete(article);
    }
}
