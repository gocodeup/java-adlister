package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.VerifyData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {





    public static void main(String[] args) {
        System.out.println(VerifyData.isValidUsername("test this"));
        System.out.println(VerifyData.isValidUsername("testthis1"));
        System.out.println(VerifyData.isValidEmail("test123@test.com"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/profile");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("confirm_password");

        // validate input
        // create and save a new user

        boolean userNameNotExist = VerifyData.userNameNotExist(username);
        boolean userEmailNotExist = VerifyData.userEmailNotExist(email);

        boolean isValidEmail = VerifyData.isValidEmail(email);
        boolean isValidUserName = VerifyData.isValidUsername(username);


        String userNameExistsMessage = "Username " + username + " already exists, please try again.";
        String userEmailExistsMessage = "An user with this email already exists, please try again.";
        String userPasswordsDoNotMatch = "Password does not match, please enter matching confirmation password";
        String invalidEmailMessage = email + " is not a valid email, please enter a valid email";
        String invalidUserNameMessage = "Invalid username, usernames may only contain letters, numbers and underscores.";
        String alert = " <span style=\"color:red\">*</span>";

        /// I still need to refactor this to also have sticky form function along with checking if the data exists
        if (!isValidEmail && !isValidUserName) {
            request.setAttribute("invalidEmailMessage", invalidEmailMessage);
            request.setAttribute("invalidUserNameMessage", invalidUserNameMessage);
            request.setAttribute("userEmailExistsHTML", alert);
            request.setAttribute("userNameExistsHTML", alert);
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        } else if (!isValidEmail) {
            request.setAttribute("userEmailExistsHTML", alert);
            request.setAttribute("invalidEmailMessage", invalidEmailMessage);
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        } else if (!isValidUserName) {
            request.setAttribute("invalidUserNameMessage", invalidUserNameMessage);
            request.setAttribute("userNameExistsHTML", alert);
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }


        if (!userNameNotExist && !userEmailNotExist) {
            // can refactor to display "account with username and email already exists, did you forget your pw?"
            request.setAttribute("userNameExistsMessage", userNameExistsMessage);
            request.setAttribute("userEmailExistsHTML", alert);
            request.setAttribute("userNameExistsHTML", alert);
            request.setAttribute("userEmailExistsMessage", userEmailExistsMessage);
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        } else if (!userEmailNotExist) {
            // if the user email exists this will display the userEmailExistsMessage String in the input placeholder.
            request.setAttribute("userEmailExistsMessage", userEmailExistsMessage);
            request.setAttribute("userEmailExistsHTML", alert);
            request.setAttribute("usersInputUsername", username);
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        } else if (!userNameNotExist) {
            // if the user name exists this will display the userNameExistsMessage String in the input placeholder.
            request.setAttribute("userNameExistsMessage", userNameExistsMessage);
            request.setAttribute("userNameExistsHTML", alert);
            request.setAttribute("usersInputEmail", email);
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }

        boolean inputHasErrors = username.isEmpty()
            || email.isEmpty()
            || password.isEmpty()
            || (! password.equals(passwordConfirmation));

        if (inputHasErrors) {
            if (!password.equals(passwordConfirmation)) {
                request.setAttribute("noPasswordMatch", userPasswordsDoNotMatch);
                request.setAttribute("noPasswordMatchAlert", alert);
                request.setAttribute("usersInputUsername", username);
                request.setAttribute("usersInputEmail", email);
            }
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }

        User user = new User(username, email, password);
        DaoFactory.getUsersDao().insert(user);
        request.setAttribute("usersInputUsername", username);
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }
}
