package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.Config;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static java.lang.Long.parseLong;

@WebServlet(name = "UpdateInfoServlet", urlPatterns = "/updateinfo")
public class UpdateInfoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/updateinfo.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;

        } else {

            if (request.getParameter("editButton") != null) {

                // Edit Process
                User editUser = (User) request.getSession().getAttribute("user");
                Long userId = (long) editUser.getId();
                String username = request.getParameter("username");
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                String passwordConfirmation = request.getParameter("confirm_password");

                // Process Edit Action
                boolean inputHasErrors = (!password.equals(passwordConfirmation));

                if (inputHasErrors) {
                    if (inputHasErrors) {
                        JOptionPane.showMessageDialog(null,"Passwords do not match");
                        request.setAttribute("inputHasErrors", true);
                        String message = "Passwords did not  match";
                        request.setAttribute("message", message);
                        request.getRequestDispatcher("/WEB-INF/updateinfo.jsp").forward(request, response);
                } else {
                    editUser.setUsername(username);
                    editUser.setEmail(email);
                    editUser.setPassword(password);
                    DaoFactory.getUsersDao().update(editUser);
                }

            }
            response.sendRedirect("/profile");
        }
        if (request.getParameter("delete-account") != null) {

            // Edit Process
            User user = (User) request.getSession().getAttribute("user");
            DaoFactory.getUsersDao().delete(user);
            request.getSession().invalidate();
        }

    }

 }

