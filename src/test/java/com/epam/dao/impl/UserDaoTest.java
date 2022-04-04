package com.epam.dao.impl;

import com.epam.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
public class UserDaoTest {

    @Mock
    SessionFactory sessionFactory;

    @Mock
    Session session;

    @Mock
    Query<User> query;

    @InjectMocks
    UserDaoImpl userDao;

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
        when(sessionFactory.getCurrentSession()).thenReturn(session);
        when(session.get(User.class, user1.getId())).thenReturn(user1);
        User foundUser = userDao.getUserById(user1.getId());
        Assert.assertEquals(foundUser, user1);
        verify(sessionFactory, times(1)).getCurrentSession();
        verify(session, times(1)).get(User.class, user1.getId());
    }

    @Test
    public void testGetByUsername() {
        when(sessionFactory.getCurrentSession()).thenReturn(session);
        when(session.createQuery("FROM User WHERE username=:usernameParam", User.class)).thenReturn(query);
        when(query.uniqueResult()).thenReturn(user1);
        User foundUser = userDao.getUserByUsername(user1.getUsername());
        Assert.assertEquals(foundUser, user1);
        verify(sessionFactory, times(1)).getCurrentSession();
        verify(query, times(1)).uniqueResult();
    }
}
