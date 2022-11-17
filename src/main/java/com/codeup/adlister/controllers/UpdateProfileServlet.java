package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.util.Password;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateProfileServlet", urlPatterns = "/profile/update")
public class UpdateProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Setting attribute with the value of userId in url string query.
        request.setAttribute("userId", request.getParameter("userId"));
        request.getRequestDispatcher("/WEB-INF/update-profile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Storing user input values from update profile form.
        Long id = Long.valueOf(request.getParameter("userId"));
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        password = Password.hash(password);

        boolean invalidInput = username.isEmpty() || email.isEmpty() || password.isEmpty();
        if (invalidInput)
        {
            request.setAttribute("inputIsNull", true);
            request.getRequestDispatcher("/WEB-INF/profile/update.jsp").forward(request, response);
        } else
        {
//            Accessing DAO to implement update users method.
                DaoFactory.getUsersDao().updateUser(id, username, email, password);
            // Redirecting them to login again.
            response.sendRedirect("/login");
        }

    }
}
