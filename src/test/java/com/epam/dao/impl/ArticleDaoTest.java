package com.epam.dao.impl;

import com.epam.entity.Article;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static com.epam.ArticleTestData.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ArticleDaoTest {

    @Mock
    SessionFactory sessionFactory;

    @Mock
    Session session;

    @Mock
    Query<Article> query;

    @InjectMocks
    ArticleDaoImpl articleDao;

    List<Article> articles;
    Article article1;
    Article article2;

    @Before
    public void setUp() {
        articles = ARTICLES;
        article1 = ARTICLE1;
        article2 = ARTICLE2;
    }

    @Test
    public void testGetAll() {
        when(sessionFactory.getCurrentSession()).thenReturn(session);
        when(session.createQuery("from Article", Article.class)).thenReturn(query);
        when(query.getResultList()).thenReturn(articles);
        List<Article> foundArticles = articleDao.getAll();
        Assert.assertEquals(foundArticles, articles);
        verify(sessionFactory, times(1)).getCurrentSession();
        verify(query, times(1)).getResultList();
    }

    @Test
    public void testGetById() {
        when(sessionFactory.getCurrentSession()).thenReturn(session);
        when(session.get(Article.class, article1.getId())).thenReturn(article1);
        Article foundArticle = articleDao.getById(article1.getId());
        Assert.assertEquals(foundArticle, article1);
        verify(sessionFactory, times(1)).getCurrentSession();
        verify(session, times(1)).get(Article.class, article1.getId());
    }

    @Test
    public void testSave() {
        when(sessionFactory.getCurrentSession()).thenReturn(session);
        when(session.save(any(Article.class))).thenReturn(0L);
        articleDao.save(article1);
        verify(sessionFactory, times(1)).getCurrentSession();
        verify(session, times(1)).save(any(Article.class));
    }

    @Test
    public void testUpdate() {
        when(sessionFactory.getCurrentSession()).thenReturn(session);
        articleDao.update(article1);
        verify(sessionFactory, times(1)).getCurrentSession();
        verify(session, times(1)).update(any(Article.class));
    }

    @Test
    public void testDeleteById() {
        when(sessionFactory.getCurrentSession()).thenReturn(session);
        when(session.get(Article.class, article1.getId())).thenReturn(article1);
        articleDao.deleteById(article1.getId());
        verify(sessionFactory, times(1)).getCurrentSession();
        verify(session, times(1)).delete(article1);
    }

    @Test(expected = HibernateException.class)
    public void testDeleteByIdException() {
        when(sessionFactory.getCurrentSession()).thenReturn(session);
        doThrow(new HibernateException("")).when(session).delete(null);
        articleDao.deleteById(IMPOSSIBLE_ID);
        verify(sessionFactory, times(1)).getCurrentSession();
        verify(session, times(1)).delete(null);
    }

    @Test(expected = HibernateException.class)
    public void testUpdateException() {
        when(sessionFactory.getCurrentSession()).thenReturn(session);
        doThrow(new HibernateException("")).when(session).update(article1);
        articleDao.update(article1);
        verify(sessionFactory, times(1)).getCurrentSession();
        verify(session, times(1)).delete(null);
    }
}
