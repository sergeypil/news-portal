package com.epam.dao.impl;

import com.epam.dao.ArticleDao;
import com.epam.entity.Article;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class ArticleDaoImpl implements ArticleDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleDaoImpl.class);
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
        LOGGER.info("Trying to save a new article");
        session.saveOrUpdate(article);
        LOGGER.info("Saving a new article");
    }

    @Transactional
    @Override
    public void update(Article article) {
        Session session = sessionFactory.getCurrentSession();
        LOGGER.info("Trying to update article with id " + article.getId());
        session.update(article);
        LOGGER.info("Updating article with id " + article.getId());
    }

    @Transactional
    @Override
    public void deleteById(long id) {
        Session session = sessionFactory.getCurrentSession();
        Article article = session.get(Article.class, id);
        LOGGER.info("Trying to delete article with id " + id);
        session.delete(article);
        LOGGER.info("Deleting article with id " + id);
    }

    @Transactional
    @Override
    public void deleteBySeveralIds(List<String> ids) {
        Session session = sessionFactory.getCurrentSession();
        String ids_str = String.join(",", ids);
        String query = "DELETE FROM ARTICLE WHERE id IN(" + ids_str + ")";
        NativeQuery nativeQuery = session.createSQLQuery(query);
        LOGGER.info("Trying to delete articles with ids:" + ids_str);
        nativeQuery.executeUpdate();
        LOGGER.info("Deleting articles with ids:" + ids_str);
    }
}
