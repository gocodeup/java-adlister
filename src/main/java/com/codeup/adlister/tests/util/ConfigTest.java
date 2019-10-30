/*
 *  This file tests the methods in util/Config.java
 *  Created by: Yael Brown
 *  Date: October 30, 2019
 */

package com.codeup.adlister.tests.java.util;

import com.codeup.adlister.util.Config;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConfigTest {

    private Config c = new Config();

    // Test that url is present in config
    @Test
    public void testGetUrl() {
        String result = c.getUrl();
        Assertions.assertNotNull(result);
    }

    // Test that user is present and equals 'root'
    @Test
    public void testGetUser() {
        String result = c.getUser();
        Assertions.assertNotNull(result);
        Assertions.assertEquals("root", result);
    }

    // Test that password is present and equals 'codeup'
    @Test
    public void testGetPassword() {
        String result = c.getPassword();
        Assertions.assertNotNull(result);
        Assertions.assertEquals("codeup", result);
    }

}