package service.impl;

import static com.epam.TestData.*;
import com.epam.entity.Article;
import com.epam.service.ArticleService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ArticleServiceTest {

    @Mock
    ArticleService articleService;

    @Test
    public void testGetAll() {
        when(articleService.getAll()).thenReturn(ARTICLES);
        List<Article> articles = articleService.getAll();
        Assert.assertEquals(articles, ARTICLES);
        verify(articleService, times(1)).getAll();
    }

    @Test
    public void testGetById() {
        when(articleService.getById(ARTICLE1.getId())).thenReturn(ARTICLE1);
        Article foundedArticle = articleService.getById(ARTICLE1.getId());
        Assert.assertEquals(foundedArticle, ARTICLE1);
        verify(articleService, times(1)).getById(ARTICLE1.getId());
    }

    @Test
    public void testSave() {
        articleService.save(ARTICLE1);
        verify(articleService, times(1)).save(ARTICLE1);
    }

    @Test
    public void testUpdate() {
        articleService.update(ARTICLE1);
        verify(articleService, times(1)).update(ARTICLE1);
    }

    @Test
    public void testDeleteById() {
        articleService.deleteById(ARTICLE1.getId());
        verify(articleService, times(1)).deleteById(anyLong());
    }
}
