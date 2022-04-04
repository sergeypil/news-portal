package com.epam.controller;

import com.epam.dto.ArticleWithoutContent;
import com.epam.entity.Article;
import com.epam.service.ArticleService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.BindingResult;

import java.util.List;

import static com.epam.ArticleTestData.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class ArticleControllerTest {
    @Mock
    ArticleService articleService;

    @Mock
    BindingResult result;

    @InjectMocks
    ArticleController articleController;

    private MockMvc mockMvc;

    List<Article> articles;
    Article article1;
    Article article2;
    List<String> ids;
    ArticleWithoutContent articleWithoutContent;

    @Before
    public void setUp() {
        articleController = new ArticleController(articleService);
        articles = ARTICLES;
        article1 = ARTICLE1;
        article2 = ARTICLE2;
        ids = List.of("1", "2");
        articleWithoutContent = ARTICLE_WITHOUT_CONTENT;
        mockMvc = MockMvcBuilders.standaloneSetup(articleController).build();
    }

    @Test
    public void testGetAllArticles() throws Exception {
        when(articleService.getAll()).thenReturn(articles);
        mockMvc.perform(get("/newapi/articles")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].id").value(article1.getId()));
        verify(articleService, times(1)).getAll();
    }

    @Test
    public void testGetArticleById() throws Exception {
        Article article = article1;
        when(articleService.getById(article.getId())).thenReturn(article1);
        mockMvc.perform(get("/newapi/articles/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value(article.getTitle()));
        verify(articleService, times(1)).getById(article.getId());
    }

    @Test
    public void testDeleteArticleById() throws Exception {
        mockMvc.perform(delete("/newapi/articles/1"))
                .andExpect(status().isOk());
        verify(articleService, times(1)).deleteById(article1.getId());
    }

    @Test
    public void testDeleteArticlesByIds() throws Exception {
        mockMvc.perform(post("/newapi/articles/ids")
                        .content("{\"ids\": [\"1\", \"2\"]}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(articleService, times(1)).deleteByIds(ids);
    }

    @Test
    public void testUpdateArticle() throws Exception {
        mockMvc.perform(put("/newapi/articles/")
                        .content("{\"id\": \"1\",\n" +
                        "    \"title\": \"Tit\",\n" +
                        "    \"brief\": \"Brief content\",\n" +
                        "    \"content\": \"Content\",\n" +
                        "    \"created\": \"2022-04-02T11:30:35\"}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(articleService, times(1)).update(article1);
    }

    @Test
    public void testPartialUpdateArticle() throws Exception {
        mockMvc.perform(patch("/newapi/articles/")
                        .content("{\"id\": \"1\",\n" +
                                "    \"title\": \"Tit\",\n" +
                                "    \"brief\": \"Brief content\",\n" +
                                "    \"created\": \"2022-04-02T11:30:35\"}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(articleService, times(1)).update(articleWithoutContent);
    }

    @Test
    public void testSaveArticleWithSuccess() throws Exception {
        mockMvc.perform(post("/newapi/articles/")
                        .content("{\"id\": \"1\",\n" +
                                "    \"title\": \"Tit\",\n" +
                                "    \"brief\": \"Brief content\",\n" +
                                "    \"content\": \"Content\",\n" +
                                "    \"created\": \"2022-04-02T11:30:35\"}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
        verify(articleService, times(1)).save(article1);
    }

    @Test
    public void testSaveArticleWithValidationError() {
        when(result.hasErrors()).thenReturn(true);
        Assert.assertEquals(articleController.createArticle(ARTICLE1_WITH_NULL_TITLE, result),new ResponseEntity<>("", HttpStatus.BAD_REQUEST));
    }

    @Test
    public void testUpdateArticleWithValidationError() {
        when(result.hasErrors()).thenReturn(true);

        Assert.assertEquals(articleController.updateArticle(ARTICLE1_WITH_NULL_TITLE, result),new ResponseEntity<>("", HttpStatus.BAD_REQUEST));
    }

    @Test
    public void testPartialUpdateArticleWithValidationError() {
        when(result.hasErrors()).thenReturn(true);
        Assert.assertEquals(articleController.updateArticle(articleWithoutContent, result),new ResponseEntity<>("", HttpStatus.BAD_REQUEST));
    }
}
