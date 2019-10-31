package com.codeup.adlister.tests.dao;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MySQLUsersDaoTest {

    @BeforeAll
    void setUp() {
        User u = new User("junitTestUser", "test@junit.com", "junitpassword");
        User u2 = new User("junitTestUser2", "test@junit.com", "junitpassword");
        DaoFactory.getUsersDao().insert(u);
        DaoFactory.getUsersDao().insert(u2);
    }

    @AfterAll
    void breakDown() {
        DaoFactory.getUsersDao().deleteUser("junitTestUser");
        DaoFactory.getUsersDao().deleteUser("junitTestUser2");
    }

    @Test
    void findByUsername() {
        assertEquals("test@junit.com", DaoFactory.getUsersDao().findByUsername("junitTestUser").getEmail());
    }

    @Test
    void insert() {
        assertNotNull(DaoFactory.getUsersDao().findByUsername("junitTestUser"));
    }

    @Test
    void findById() {
        Long lId = DaoFactory.getUsersDao().findByUsername("junitTestUser2").getId();
        assertEquals("junitTestUser2", DaoFactory.getUsersDao().findById(lId).getUsername());
    }
}