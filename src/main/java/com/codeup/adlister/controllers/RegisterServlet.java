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
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        System.out.println(password);
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
        User user = new User(username, email, password);
        System.out.println(user.getPassword());
        System.out.println(user.getEmail());
        System.out.println(user.getUsername());
        DaoFactory.getUsersDao().insert(user);
        response.sendRedirect("/login");

        User userName = DaoFactory.getUsersDao().findByUsername(username);


        boolean valid = false;

        if(userName != null && username.equals(userName.getUsername())) {
            request.setAttribute("usernameExists", "This username already exists.");
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        } else if (!password.equals(passwordConfirmation)) {
            request.setAttribute("passwordError", "The passwords do not match!");
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        } else {
            valid = true;
        }


            // create and save a new user
       // if(valid) {
       //     User user = new User(username, email, password);
       //     DaoFactory.getUsersDao().insert(user);
       //     response.sendRedirect("/login");
       // }

    }


}
