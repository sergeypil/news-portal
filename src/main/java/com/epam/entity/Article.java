package com.epam.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.Date;

public class Article {
    private long id;
    @NotNull(message = "Title cannot be null")
    @Size(min = 1,max = 100,message = "Title size must be between 1 and 100")
    private String title;
    @NotNull(message = "Brief cannot be null")
    @Size(min = 1,max = 500,message = "Brief size must be between 1 and 500")
    private String brief;
    @NotNull(message = "Content cannot be null")
    @Size(min = 1,max = 2048,message = "Content size must be between 1 and 2048")
    private String content;
    private Date created;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}


