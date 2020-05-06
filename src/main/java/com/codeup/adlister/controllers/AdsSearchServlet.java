package com.codeup.adlister.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdsSearchServlet {
    @WebServlet(name = "controllers.AdsSearchServlet", urlPatterns = "/ads/search")
    public class AdSearchServlet extends HttpServlet {
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            if (request.getSession().getAttribute("user") == null) {
                response.sendRedirect("/login");
                return;
            }
            request.getRequestDispatcher("/WEB-INF/ads/ads_search.jsp")
                    .forward(request, response);
        }
    }
}
