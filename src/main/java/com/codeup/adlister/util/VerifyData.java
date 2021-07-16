package com.codeup.adlister.util;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerifyData {

    // Verifies that your email address is in email address format IE random@email.com and not null
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern p = Pattern.compile(emailRegex);

        if (email == null)
            return false;
        Matcher m = p.matcher(email);

        return m.matches();
    }
    // Checks for username to contain only a-z or A-Z 0-9 and _'s and must be 5-30 chars long and not null
    public static boolean isValidUsername(String name) {
        String regex = "\\w{5,30}";

        Pattern p = Pattern.compile(regex);

        if (name == null)
            return false;
        Matcher m = p.matcher(name);

        return m.matches();
    }

    public static boolean userNameNotExist(String name) {
        User userNameTest = DaoFactory.getUsersDao().findByUsername(name);
        return userNameTest == null;
    }
    public static boolean userEmailNotExist(String email) {
        User userEmailTest = DaoFactory.getUsersDao().findByUserEmail(email);
        return userEmailTest == null;
    }
}
