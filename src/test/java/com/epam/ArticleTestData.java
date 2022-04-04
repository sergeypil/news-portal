package com.epam;

import com.epam.dto.ArticleWithoutContent;
import com.epam.entity.Article;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArticleTestData {
    public static final Article ARTICLE1;
    public static final Article ARTICLE2;
    public static final Article ARTICLE1_WITH_NULL_TITLE;
    public static final List<Article> ARTICLES;
    public static final ArticleWithoutContent ARTICLE_WITHOUT_CONTENT;
    public static final long IMPOSSIBLE_ID = -1L;

    static {
        ARTICLE1 = new Article();
        ARTICLE1.setId(1L);
        ARTICLE1.setTitle("Tit");
        ARTICLE1.setBrief("Brief content");
        ARTICLE1.setContent("Content");
        LocalDateTime dateTime1 = LocalDateTime.parse("2022-04-02T11:30:35");
        ARTICLE1.setCreated(Date.from(dateTime1.toInstant(ZoneOffset.UTC)));

        ARTICLE2 = new Article();
        ARTICLE2.setId(2L);
        ARTICLE2.setTitle("Titlee");
        ARTICLE2.setBrief("Brief content");
        ARTICLE2.setContent("Content");
        LocalDateTime dateTime2 = LocalDateTime.parse("2022-04-02T11:30:36");
        ARTICLE2.setCreated(Date.from(dateTime2.toInstant(ZoneOffset.UTC)));

        ARTICLE1_WITH_NULL_TITLE = new Article();
        ARTICLE1_WITH_NULL_TITLE.setId(1L);
        ARTICLE1_WITH_NULL_TITLE.setBrief("Brief content");
        ARTICLE1_WITH_NULL_TITLE.setContent("Content");
        LocalDateTime dateTime3 = LocalDateTime.parse("2022-04-02T11:30:35");
        ARTICLE1_WITH_NULL_TITLE.setCreated(Date.from(dateTime1.toInstant(ZoneOffset.UTC)));

        ARTICLES = new ArrayList<>();
        ARTICLES.add(ARTICLE1);
        ARTICLES.add(ARTICLE2);

        ARTICLE_WITHOUT_CONTENT = mapArticleToArticleWithoutContent(ARTICLE1);
    }

    private static ArticleWithoutContent mapArticleToArticleWithoutContent(Article article) {
    ArticleWithoutContent articleWithoutContent = new ArticleWithoutContent();
    articleWithoutContent.setId(article.getId());
    articleWithoutContent.setTitle(article.getTitle());
    articleWithoutContent.setBrief(article.getBrief());
    articleWithoutContent.setBrief(article.getBrief());
    articleWithoutContent.setCreated(article.getCreated());
    return articleWithoutContent;
    }
}
