package dao.impl;

import com.epam.dao.ArticleDao;
import com.epam.entity.Article;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static com.epam.TestData.ARTICLE1;
import static com.epam.TestData.ARTICLES;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class ArticleDaoTest {

    @Mock
    ArticleDao articleDao;

    @Test
    public void testGetAll() {
        when(articleDao.getAll()).thenReturn(ARTICLES);
        List<Article> articles = articleDao.getAll();
        Assert.assertEquals(articles, ARTICLES);
        verify(articleDao, times(1)).getAll();
    }

    @Test
    public void testGetById() {
        when(articleDao.getById(ARTICLE1.getId())).thenReturn(ARTICLE1);
        Article foundedArticle = articleDao.getById(ARTICLE1.getId());
        Assert.assertEquals(foundedArticle, ARTICLE1);
        verify(articleDao, times(1)).getById(ARTICLE1.getId());
    }

    @Test
    public void testSave() {
        articleDao.save(ARTICLE1);
        verify(articleDao, times(1)).save(ARTICLE1);
    }

    @Test
    public void testUpdate() {
        articleDao.update(ARTICLE1);
        verify(articleDao, times(1)).update(ARTICLE1);
    }

    @Test
    public void testDeleteById() {
        articleDao.deleteById(ARTICLE1.getId());
        verify(articleDao, times(1)).deleteById(anyLong());
    }
}
