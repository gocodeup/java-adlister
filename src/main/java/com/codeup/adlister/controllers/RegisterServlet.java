package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String errorMessage = request.getParameter("errorMessage");
        request.setAttribute("errorMessage", errorMessage);
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("confirm_password");

        // validate input
        boolean inputHasErrors = username.isEmpty()
                || email.isEmpty()
                || password.isEmpty()
                || (!password.equals(passwordConfirmation));

        if (inputHasErrors) {
            response.sendRedirect("/register");
            return;
        }

        // create and save a new user
        User user = new User(username, email, password);

        try {
            boolean usernameAndEmailNotValid = DaoFactory.getUsersDao().validateUsername(username) &&
                    DaoFactory.getUsersDao().validateEmail(email);
            boolean usernameNotValid = DaoFactory.getUsersDao().validateUsername(username);
            boolean userEmailNotValid = DaoFactory.getUsersDao().validateEmail(email);

            if (usernameAndEmailNotValid) {
                request.setAttribute("bothTaken", true);
                request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            } else if (usernameNotValid) {
                request.setAttribute("usernameTaken", true);
                request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            } else if (userEmailNotValid) {
                request.setAttribute("emailTRaken", true);
                request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
        try {
            user = new User(username, email, password);
            request.getSession().setAttribute("user", user);
            DaoFactory.getUsersDao().insert(user);
            response.sendRedirect("/profile");
//        } catch (SQLException e) {
//            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        request.getSession().setAttribute("username", null);
//        request.getSession().setAttribute("email", null);
//        DaoFactory.getUsersDao().insert(user);
//        response.sendRedirect("/login");
    }
}