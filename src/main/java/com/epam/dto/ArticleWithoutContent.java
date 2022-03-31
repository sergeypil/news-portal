package com.epam.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class ArticleWithoutContent {
        private long id;
        @NotNull(message = "Title cannot be null")
        @Size(min = 1,max = 100,message = "Title size must be between 1 and 100")
        private String title;
        @NotNull(message = "Brief cannot be null")
        @Size(min = 1,max = 500,message = "Brief size must be between 1 and 500")
        private String brief;
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

        public Date getCreated() {
            return created;
        }

        public void setCreated(Date created) {
            this.created = created;
        }
    }
