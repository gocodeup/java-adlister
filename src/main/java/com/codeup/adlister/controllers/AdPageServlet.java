package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.AdsIndexServlet", urlPatterns = "/ad")
public class AdPageServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("search") == null) {
            response.sendRedirect("/ads");
        } else if (request.getSession().getAttribute("id") == null) {
            response.sendRedirect("/search");
        } else {

            Cookie message = new Cookie("message", "Welcome to a specific ad page.");
            request.setAttribute("ads", DaoFactory.getAdsDao().thisAd((Long) request.getSession().getAttribute("id")));
            request.getRequestDispatcher("/WEB-INF/AdLanding.jsp").forward(request, response);
            response.addCookie(message);
        }
    }
}
