package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "controllers.ViewProfileServlet", urlPatterns = "/profile")
public class ViewProfileServlet extends HttpServlet {
    long userId;
    String username;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
HttpSession session = request.getSession();

        if (session.getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }

        String username = (String) session.getAttribute("username");
        userId = (long) session.getAttribute("userId");
        request.setAttribute("ads", DaoFactory.getAdsDao().findAd(userId));
        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
    }
}
