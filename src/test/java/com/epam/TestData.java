package com.epam;

import com.epam.entity.Article;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestData {
    public static final Article ARTICLE1;
    public static final Article ARTICLE2;
    public static final List<Article> ARTICLES;

    static {
        ARTICLE1 = new Article();
        ARTICLE1.setId(1L);
        ARTICLE1.setTitle("Title");
        ARTICLE1.setBrief("Brief content");
        ARTICLE1.setContent("Content");
        ARTICLE1.setCreated(new Date());

        ARTICLE2 = new Article();
        ARTICLE2.setId(2L);
        ARTICLE2.setTitle("Title");
        ARTICLE2.setBrief("Brief content");
        ARTICLE2.setContent("Content");
        ARTICLE2.setCreated(new Date());

        ARTICLES = new ArrayList<>();
        ARTICLES.add(ARTICLE1);
        ARTICLES.add(ARTICLE2);
    }
}
