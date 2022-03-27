package com.epam.dao;

import com.epam.entity.Article;
import com.epam.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserDao {
    public List<User> getAllUsers();
    User getUserById(long id);
    User getUserByUsername(String username);
}
