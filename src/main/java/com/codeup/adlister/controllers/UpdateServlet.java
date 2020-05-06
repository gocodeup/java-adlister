package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "controllers.UpdateServlet", urlPatterns = "/update")
public class UpdateServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/update.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        // validate input

//        boolean inputHasErrors = ;
        if (username.isEmpty()
                || password.isEmpty()
                || email.isEmpty()){
        response.sendRedirect("/update");}


        if (DaoFactory.getUsersDao().findByUsername(username) != null) {
            request.getSession().setAttribute("errorMessage", "Username already exists, please choose another one!");
            response.sendRedirect("/update");
        } else {
            request.getSession().removeAttribute("errorMessage");

            response.sendRedirect("/update");
        }
    }
}