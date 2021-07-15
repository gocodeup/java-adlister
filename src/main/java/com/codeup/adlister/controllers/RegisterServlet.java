package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
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
        boolean inputHasErrors = username.isEmpty()
            || email.isEmpty()
            || password.isEmpty()
            || (! password.equals(passwordConfirmation));

        if (inputHasErrors) {
            response.sendRedirect("/register");
            return;
        }

        // create and save a new user
        boolean userNameNotExist = false;
        boolean userEmailNotExist = false;
        boolean noUserConflicts = false;

        User userNameTest = DaoFactory.getUsersDao().findByUsername(username);
        User userEmailTest = DaoFactory.getUsersDao().findByUserEmail(email);

        if (userNameTest == null) {
            userNameNotExist = true;
        }
        if (userEmailTest == null) {
            userEmailNotExist = true;
        }
        if (userNameNotExist && userEmailNotExist) {
            noUserConflicts = true;
        }

        String userNameExistsMessage = "Username already exists, please try again.";
        String userEmailExistsMessage = "An user with this email already exists, please try again.";

        if (noUserConflicts) {
             User user = new User(username, email, password);
             DaoFactory.getUsersDao().insert(user);
             response.sendRedirect("/login");
        } else if (!userNameNotExist && !userEmailNotExist) {
            // can refactor to display "account with username and email already exists, did you forget your pw?"
            request.setAttribute("userNameExistsMessage", userNameExistsMessage);
            request.setAttribute("userEmailExistsMessage", userEmailExistsMessage);
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        } else if (!userEmailNotExist) {
            // if the user email exists this will display the userEmailExistsMessage String in the input placeholder.
            request.setAttribute("userEmailExistsMessage", userEmailExistsMessage);
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        } else if (!userNameNotExist) {
            // if the user name exists this will display the userNameExistsMessage String in the input placeholder.
            request.setAttribute("userNameExistsMessage", userNameExistsMessage);
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
    }
}
