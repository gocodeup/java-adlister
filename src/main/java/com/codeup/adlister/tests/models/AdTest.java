/*
 *  This file tests the methods in models/Ad.java
 *  Created by: Yael Brown
 *  Date: October 30, 2019
 */

package com.codeup.adlister.tests.models;

import com.codeup.adlister.models.Ad;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdTest {

    private Ad a = new Ad(3L, 3L, "Test", "Test description", "testUsername");

    @Test
    void getId() {
        assertEquals(3L, a.getId());
    }

    @Test
    void setId() {
        a.setId(1L);
        assertEquals(1L, a.getId());
    }

    @Test
    void getUserId() {
        assertEquals(3L, a.getUserId());
    }

    @Test
    void setUserId() {
        a.setUserId(1L);
        assertEquals(1L, a.getUserId());
    }

    @Test
    void getTitle() {
        assertEquals("Test", a.getTitle());
    }

    @Test
    void setTitle() {
        a.setTitle("Changed Title");
        assertEquals("Changed Title", a.getTitle());
    }

    @Test
    void getDescription() {
        assertEquals("Test description", a.getDescription());
    }

    @Test
    void setDescription() {
        a.setDescription("Changed");
        assertEquals("Changed", a.getDescription());
    }

    @Test
    void getUsername() {
        assertEquals("testUsername", a.getUsername());
    }

    @Test
    void setUsername() {
        a.setUsername("newName");
        assertEquals("newName", a.getUsername());
    }
}