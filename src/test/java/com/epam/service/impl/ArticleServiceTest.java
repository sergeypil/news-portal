package com.epam.service.impl;

import static com.epam.ArticleTestData.*;

import com.epam.dao.ArticleDao;
import com.epam.entity.Article;
import com.epam.service.impl.ArticleServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ArticleServiceTest {

    @Mock
    ArticleDao articleDao;

    @InjectMocks
    ArticleServiceImpl articleService;

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
        when(articleDao.getAll()).thenReturn(articles);
        List<Article> foundedArticles = articleService.getAll();
        Assert.assertEquals(foundedArticles, articles);
        verify(articleDao, times(1)).getAll();
    }

    @Test
    public void testGetById() {
        when(articleDao.getById(article1.getId())).thenReturn(article1);
        Article foundedArticle = articleService.getById(article1.getId());
        Assert.assertEquals(foundedArticle, article1);
        verify(articleDao, times(1)).getById(article1.getId());
    }

    @Test
    public void testSave() {
        when(articleDao.save(any(Article.class))).thenReturn(anyLong());
        articleService.save(article1);
        verify(articleDao, times(1)).save(any(Article.class));
    }

    @Test
    public void testUpdate() {
        articleService.update(article1);
        verify(articleDao, times(1)).update(article1);
    }

    @Test
    public void testDeleteById() {
        articleService.deleteById(article1.getId());
        verify(articleDao, times(1)).deleteById(anyLong());
    }
}
