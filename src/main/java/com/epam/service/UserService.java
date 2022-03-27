package com.epam.service;

import com.epam.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    User getUserById(long id);
    User getUserByUsername(String username);
}
