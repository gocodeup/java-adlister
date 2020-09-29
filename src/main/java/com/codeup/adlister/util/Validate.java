package com.codeup.adlister.util;

public class Validate {
    public static boolean length(String input, int min, int max) {
        int length = input.length();
        return length >= min && length <= max;
    }
}
