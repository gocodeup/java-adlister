package com.codeup.adlister.util;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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

    // Checks to see if email is invalid or exists and checks to see if username is invalid or exists.
    // If one of these conditions is met it will execute the code block where the conditions is checked and forward the requests to
    // the passed in jsp file and return false. If no condition is met returns true.
    public static boolean checkUserInputAndGenerateErrorMessages(HttpServletRequest request, HttpServletResponse response, String username, String email, String password, String passwordConfirmation, String jsp) throws ServletException, IOException {
        boolean userNameNotExist = VerifyData.userNameNotExist(username);
        boolean userEmailNotExist = VerifyData.userEmailNotExist(email);

        boolean isValidEmail = VerifyData.isValidEmail(email);
        boolean isValidUserName = VerifyData.isValidUsername(username);

        String userNameExistsMessage = "Username " + username + " already exists, please try again.";
        String userEmailExistsMessage = "An user with this email already exists, please try again.";
        String userPasswordsDoNotMatchMessage = "Password does not match, please enter matching confirmation password";
        String invalidEmailMessage = email + " is not a valid email, please enter a valid email";
        String invalidUserNameMessage = "Invalid username, usernames may only contain letters, numbers and underscores.";
        String alert = " <span style=\"color:red\">*</span>";

        if (!isValidEmail || !userEmailNotExist || !isValidUserName || !userNameNotExist) {
            if (!isValidEmail) {
                request.setAttribute("userEmailExistsHTML", alert);
                request.setAttribute("invalidEmailMessage", invalidEmailMessage);
            }
            if (!isValidUserName) {
                request.setAttribute("userNameExistsHTML", alert);
                request.setAttribute("invalidUserNameMessage", invalidUserNameMessage);
            }
            if (userNameNotExist && isValidUserName) {
                request.setAttribute("usersInputUsername", username);
            } else if (!userNameNotExist && isValidUserName) {
                request.setAttribute("userNameExistsMessage", userNameExistsMessage);
                request.setAttribute("userNameExistsHTML", alert);
            }
            if (userEmailNotExist && isValidEmail) {
                request.setAttribute("usersInputEmail", email);
            } else if (!userEmailNotExist && isValidEmail) {
                request.setAttribute("userEmailExistsMessage", userEmailExistsMessage);
                request.setAttribute("userEmailExistsHTML", alert);
            }
            request.getRequestDispatcher("/WEB-INF/" + jsp + ".jsp").forward(request, response);
            return false;
        }

        if (!password.equals(passwordConfirmation)) {
            request.setAttribute("noPasswordMatchMessage", userPasswordsDoNotMatchMessage);
            request.setAttribute("noPasswordMatchAlert", alert);
            request.setAttribute("usersInputUsername", username);
            request.setAttribute("usersInputEmail", email);
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return false;
        }

        return true;
    }
}
