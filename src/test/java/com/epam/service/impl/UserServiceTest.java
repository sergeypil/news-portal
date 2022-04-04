package com.epam.service.impl;

import com.epam.dao.UserDao;
import com.epam.entity.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static com.epam.UserTestData.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    @Mock
    UserDao userDao;

    @InjectMocks
    UserServiceImpl userService;

    List<User> users;
    User user1;
    User user2;

    @Before
    public void setUp() {
        users = USERS;
        user1 = USER1;
        user2 = USER2;
    }

    @Test
    public void testGetById() {
        when(userDao.getUserById(user1.getId())).thenReturn(user1);
        User foundUser = userService.getUserById(user1.getId());
        Assert.assertEquals(foundUser, user1);
        verify(userDao, times(1)).getUserById(user1.getId());
    }

    @Test
    public void testGetByUsername() {
        when(userDao.getUserByUsername(user1.getUsername())).thenReturn(user1);
        User foundUser = userService.getUserByUsername(user1.getUsername());
        Assert.assertEquals(foundUser, user1);
        verify(userDao, times(1)).getUserByUsername(user1.getUsername());
    }
}
