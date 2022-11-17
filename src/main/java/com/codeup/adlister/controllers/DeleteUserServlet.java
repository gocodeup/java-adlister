package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteUserServlet", urlPatterns = "/profile/delete")
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("userId", request.getParameter("userId"));
        request.getRequestDispatcher("/WEB-INF/delete-profile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("userId"));
        if (request.getSession().getAttribute("user") != null) {
            Long userId = Long.valueOf(request.getParameter("userId"));
            DaoFactory.getUsersDao().deleteUser(userId);
            response.sendRedirect("/login");
        } else {
            response.sendRedirect("/ads");
        }
    }
}
