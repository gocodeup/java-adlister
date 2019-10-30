/*
 *  This file tests the methods in models/User.java
 *  Created by: Yael Brown
 *  Date: October 30, 2019
 */

package com.codeup.adlister.tests.models;

import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class UserTest {
    private User u = new User(12L, "uname", "email", "password");

    @Test
    void getId() {
        assertEquals(12L, u.getId());
    }

    @Test
    void setId() {
        u.setId(20L);
        assertEquals(20L, u.getId());
    }

    @Test
    void getUsername() {
        assertEquals("uname", u.getUsername());
    }

    @Test
    void setUsername() {
        u.setUsername("changed");
        assertEquals("changed", u.getUsername());
    }

    @Test
    void getEmail() {
        assertEquals("email", u.getEmail());
    }

    @Test
    void setEmail() {
        u.setEmail("newEmail");
        assertEquals("newEmail", u.getEmail());
    }

    @Test
    void getPassword() {
        assertEquals("password", u.getPassword());
    }

    @Test
    void setPassword() {
        u.setPassword("newPass");
        assertNotEquals("newPass", u.getPassword());
        assertTrue(Password.check("newPass", u.getPassword()));
    }

}