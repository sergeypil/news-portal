package com.epam.controller;

import com.epam.entity.Article;
import com.epam.service.ArticleService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringJUnit4ClassRunner.class)
public class ArticleControllerTest {
    @Mock
    ArticleService articleService;

    @InjectMocks
    ArticleController articleController;

    private MockMvc mockMvc;

    Article article1;
    Article article2;
    List<Article> articles;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        article1 = new Article();
        article1.setId(1L);
        article1.setTitle("Title");
        article1.setBrief("Brief content");
        article1.setContent("Content");
        article1.setCreated(new Date());

        article2 = new Article();
        article2.setId(2L);
        article2.setTitle("Title");
        article2.setBrief("Brief content");
        article2.setContent("Content");
        article2.setCreated(new Date());

        articles = new ArrayList<>();
        articles.add(article1);
        articles.add(article2);

        articleController = new ArticleController(articleService);
        mockMvc = MockMvcBuilders.standaloneSetup(articleController).build();
    }

    @Test
    public void getAllNews() throws Exception {
        //given
        List<Article> news = articles;
        when(articleService.getAllArticles()).thenReturn(articles);

        //when
        mockMvc.perform(get("/newapi/articles")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].id").value(article1.getId()));

        //then
        verify(articleService, times(1)).getAllArticles();
    }
}
