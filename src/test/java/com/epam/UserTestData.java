package com.epam;

import com.epam.entity.User;

import java.util.List;

public class UserTestData {
    public static final User USER1;
    public static final User USER2;
    public static final List<User> USERS;

    static {
        USER1 = new User(1,"user1", "123");
        USER2 = new User(2, "user2", "345");
        USERS = List.of(USER1, USER2);
    }
}
