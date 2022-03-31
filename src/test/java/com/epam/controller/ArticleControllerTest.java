package com.epam.controller;

import com.epam.TestData;
import com.epam.entity.Article;
import com.epam.service.ArticleService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringJUnit4ClassRunner.class)
@RunWith(MockitoJUnitRunner.class)
public class ArticleControllerTest {
    @Mock
    ArticleService articleService;

    @InjectMocks
    ArticleController articleController;

    private MockMvc mockMvc;

    Article article1 = TestData.ARTICLE1;
    Article article2 = TestData.ARTICLE2;
    List<Article> articles = TestData.ARTICLES;

    @Before
    public void setUp() {
        articleController = new ArticleController(articleService);
        mockMvc = MockMvcBuilders.standaloneSetup(articleController).build();
    }

    @Test
    public void testGetAllArticles() throws Exception {
        //given
        List<Article> news = articles;
        when(articleService.getAll()).thenReturn(articles);

        //when
        mockMvc.perform(get("/newapi/articles")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].id").value(article1.getId()));

        //then
        verify(articleService, times(1)).getAll();
    }

    @Test
    public void testGetArticleById() throws Exception {
        //given
        Article article = article1;
        when(articleService.getById(article.getId())).thenReturn(article1);

        //when
        mockMvc.perform(get("/newapi/articles/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value(article.getTitle()));

        //then
        verify(articleService, times(1)).getById(article.getId());
    }

    @Test
    public void testDeleteArticle() throws Exception {

    }

    @Test
    public void testUpdateArticle() throws Exception {

}
}
