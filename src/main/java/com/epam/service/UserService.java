package com.epam.service;

import com.epam.entity.User;

public interface UserService {
    User getUserById(long id);
    User getUserByUsername(String username);
}
