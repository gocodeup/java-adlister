package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.ViewProfileServlet", urlPatterns = "/profile")
public class ViewProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie message = new Cookie("message", "Welcome to the profile page");
        request.setAttribute("blocks", DaoFactory.getBlocksDao().all());


        if (request.getSession().getAttribute("user") == null) {
            response.addCookie(message);
            response.sendRedirect("/login");
            return;
        }
        User sessionUser = (User) request.getSession().getAttribute("user");
        request.setAttribute("ads", DaoFactory.getAdsDao().userAds((sessionUser.getId())));
        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
    }

}
