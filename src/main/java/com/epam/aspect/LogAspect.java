package com.epam.aspect;

import com.epam.dto.ArticleWithoutContent;
import com.epam.entity.Article;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LogAspect {
    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private static final String LOGGER_MESSAGE_BEFORE_DELETING_BY_ID = "Trying to delete article with id ";
    private static final String LOGGER_MESSAGE_AFTER_DELETING_BY_ID = "After deleting article with id ";
    private static final String LOGGER_MESSAGE_BEFORE_DELETING_BY_IDS = "Trying to delete articles with ids ";
    private static final String LOGGER_MESSAGE_AFTER_DELETING_BY_IDS = "After deleting articles with ids ";
    private static final String LOGGER_MESSAGE_BEFORE_SAVING = "Trying to save article";
    private static final String LOGGER_MESSAGE_AFTER_SAVING = "After saving article with id ";
    private static final String LOGGER_MESSAGE_BEFORE_UPDATING = "Trying to update article with id ";
    private static final String LOGGER_MESSAGE_AFTER_UPDATING = "After updating article with id ";
    private static final String LOGGER_MESSAGE_BEFORE_PARTIAL_UPDATING = "Trying to partial update article with id ";
    private static final String LOGGER_MESSAGE_AFTER_PARTIAL_UPDATING = "After partial updating article with id ";

    public void aroundDeletingArticleById(ProceedingJoinPoint jp) throws Throwable {
        LOGGER.info(LOGGER_MESSAGE_BEFORE_DELETING_BY_ID + jp.getArgs()[0]);
        jp.proceed();
        LOGGER.info(LOGGER_MESSAGE_AFTER_DELETING_BY_ID + jp.getArgs()[0]);
    }

    public void aroundDeletingArticlesByIds(ProceedingJoinPoint jp) throws Throwable {
        LOGGER.info(LOGGER_MESSAGE_BEFORE_DELETING_BY_IDS + jp.getArgs()[0]);
        jp.proceed();
        LOGGER.info(LOGGER_MESSAGE_AFTER_DELETING_BY_IDS + jp.getArgs()[0]);
    }

    public void aroundSavingArticle(ProceedingJoinPoint jp) throws Throwable {
        LOGGER.info(LOGGER_MESSAGE_BEFORE_SAVING);
        jp.proceed();
        LOGGER.info(LOGGER_MESSAGE_AFTER_SAVING);
    }
    public void aroundUpdatingArticleById(ProceedingJoinPoint jp) throws Throwable {
        LOGGER.info(LOGGER_MESSAGE_BEFORE_UPDATING + ((Article)jp.getArgs()[0]).getId());
        jp.proceed();
        LOGGER.info(LOGGER_MESSAGE_AFTER_UPDATING + ((Article)jp.getArgs()[0]).getId());
    }
    public void aroundPartialUpdatingArticleById(ProceedingJoinPoint jp) throws Throwable {
        LOGGER.info(LOGGER_MESSAGE_BEFORE_PARTIAL_UPDATING + ((ArticleWithoutContent)jp.getArgs()[0]).getId());
        jp.proceed();
        LOGGER.info(LOGGER_MESSAGE_AFTER_PARTIAL_UPDATING + ((ArticleWithoutContent)jp.getArgs()[0]).getId());
    }
}
