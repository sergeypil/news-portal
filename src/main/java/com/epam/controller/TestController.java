package com.epam.controller;

import com.epam.dao.ArticleDao;
import com.epam.dao.UserDao;
import com.epam.entity.Article;
import com.epam.entity.User;
import com.epam.service.ArticleService;
import com.epam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class TestController {
    UserService userService;
    ArticleService articleService;

    @Autowired
    public TestController(UserService userService, ArticleService articleService) {
        this.userService = userService;
        this.articleService = articleService;
    }

    @RequestMapping(value = "/helloo", method = RequestMethod.GET)
    public String getName(Model model) {
        List<User> users = userService.getAllUsers();
        //List<UserNew> usersNew = userNewDao.getAllUsers();
        users.add(new User(4,"Kate"));
        model.addAttribute("users", users);

        List<Article> articles = articleService.getAllArticles();
        model.addAttribute("articles", articles);
        return "hello";
    }

    @RequestMapping(value = "/indexx", method = RequestMethod.GET)
    public String getIndex() {
        return "index";
    }

    @RequestMapping(value = "/hii", method = RequestMethod.GET)
    public String getHi() {
        return "hi";
    }

}
