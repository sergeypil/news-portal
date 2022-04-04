package com.epam.dao;

import com.epam.entity.User;

public interface UserDao {
    User getUserById(long id);
    User getUserByUsername(String username);
}
