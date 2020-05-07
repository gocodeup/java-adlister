package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("confirm_password");

        // validate input
        String emailRegex = "^(.+)@(.+)$";
        String userNameRegex = "^[a-zA-z0-Z0-9_-]{2,14}$";
        String passwordRegex = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,40})";
        Pattern userNamepattern = Pattern.compile(userNameRegex);
        Pattern emailPat = Pattern.compile(emailRegex);
        Pattern passwordPattern = Pattern.compile(passwordRegex);
        Matcher userNameMtch = userNamepattern.matcher(username);
        Matcher emailMtch = emailPat.matcher(email);
        Matcher passwordMtch = passwordPattern.matcher(password);
        boolean inputHasErrors = username.isEmpty()
                || !userNameMtch.matches()
                || !emailMtch.matches()
                || !passwordMtch.matches()
                || email.isEmpty()
                || password.isEmpty()
                ||DaoFactory.getUsersDao().findByUsername(username) != null
                ||DaoFactory.getUsersDao().findByEmail(email) != null
                || (!password.equals(passwordConfirmation));


        if (inputHasErrors) {
            request.setAttribute("error","Something went wrong, please make sure username, password, and email were entered correctly!");
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }

        // create and save a new user
        User user = new User(username, email, password);
        DaoFactory.getUsersDao().insert(user);
        response.sendRedirect("/login");
    }
}
