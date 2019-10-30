/*
 *  This file tests the methods in util/Password.java
 *  Created by: Yael Brown
 *  Date: October 30, 2019
 */

package com.codeup.adlister.tests.java.util;

import com.codeup.adlister.util.Password;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PasswordTest {

    private Password p = new Password();
    private String pw = "codeup";
    private String hashedPw = p.hash(pw);

    // Tests if logarithmic rounds is defined as a valid int
    @Test
    public void testROUNDS() {
        int result = p.getRounds();
        Assertions.assertNotNull(result);
    }

    // Verify hash works and does not just return the string of the password
    @Test
    public void testHash() {
        Assertions.assertNotNull(hashedPw);
        Assertions.assertNotEquals(pw, hashedPw);
    }

}
