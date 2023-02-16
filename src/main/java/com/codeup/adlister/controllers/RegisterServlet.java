package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("confirm_password");

        // validate input
        boolean userNameExists = DaoFactory.getUsersDao().findByUsername(username) != null;
        boolean inputHasErrors = username.isEmpty()
            || email.isEmpty()
            || password.isEmpty()
            || (! password.equals(passwordConfirmation));

        if (userNameExists){
            JOptionPane.showMessageDialog(null,"Please choose a new username that one exists already");
            request.setAttribute("userNameExists", true);
            response.sendRedirect("/register");

        }else if (inputHasErrors) {
            JOptionPane.showMessageDialog(null,"Passwords do not match");
            request.setAttribute("inputHasErrors", true);
            String message = "Passwords did not  match";
            request.setAttribute("message", message);
            response.sendRedirect("/register");


        }else{
            User user = new User(username, email, password);
            DaoFactory.getUsersDao().insert(user);
            response.sendRedirect("/profile");
        }

    }
}
