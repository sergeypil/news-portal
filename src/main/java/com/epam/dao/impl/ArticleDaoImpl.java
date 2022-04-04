package com.epam.dao.impl;

import com.epam.dao.ArticleDao;
import com.epam.dto.ArticleWithoutContent;
import com.epam.entity.Article;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ArticleDaoImpl implements ArticleDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public ArticleDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    @Override
    public List<Article> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Article> query = session.createQuery("from Article", Article.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public Article getById(long id) {
        Session session = sessionFactory.getCurrentSession();
        Article article = session.get(Article.class, id);
        return article;
    }

    @Transactional
    @Override
    public long save(Article article) {
        Session session = sessionFactory.getCurrentSession();
        return (long)session.save(article);
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

    @Transactional
    @Override
    public void deleteByIds(List<String> ids) {
        Session session = sessionFactory.getCurrentSession();
        String ids_str = String.join(",", ids);
        String query = "DELETE FROM ARTICLE WHERE id IN(" + ids_str + ")";
        NativeQuery nativeQuery = session.createSQLQuery(query);
        nativeQuery.executeUpdate();
    }

    @Transactional
    @Override
    public void update(ArticleWithoutContent articleWithoutContent) {
        Session session = sessionFactory.getCurrentSession();
        Article article = session.get(Article.class, articleWithoutContent.getId());
        populateArticleWithNewValues(articleWithoutContent, article);
        session.saveOrUpdate(article);
    }

    private void populateArticleWithNewValues(ArticleWithoutContent articleWithoutContent, Article article) {
        article.setTitle(articleWithoutContent.getTitle());
        article.setBrief(articleWithoutContent.getBrief());
        article.setCreated(articleWithoutContent.getCreated());
    }
}
