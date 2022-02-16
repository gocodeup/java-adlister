package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/profile");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = DaoFactory.getUsersDao().findByUsername(username);
        String errorMessage = "";

        //if username or password field is empty error message occurs
        if(username.isEmpty() || password.isEmpty()){
            errorMessage = "Username and Password are required";
            request.getSession().setAttribute("loginError", errorMessage);
            response.sendRedirect("/login");
            return;
        }

        //if user doesn't exist message will occur then will redirect to login
        if (user == null) {
            errorMessage = "You have entered an invalid username or password";
            request.getSession().setAttribute("loginError", errorMessage);
            response.sendRedirect("/login");
            return;
        }

        //boolean if password can be made into hash
        boolean validAttempt = Password.check(password, user.getPassword());

        //if boolean validattempt true user is redirected to profile
        //if false error message is created
        if (validAttempt) {
            request.getSession().setAttribute("user", user);
            response.sendRedirect("/profile");
        } else {
            errorMessage = "You have entered an invalid username or password";
            request.getSession().setAttribute("loginError", errorMessage);
            response.sendRedirect("/login");
        }

    }
}
