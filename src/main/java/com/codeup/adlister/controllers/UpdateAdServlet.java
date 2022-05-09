package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update")
public class UpdateAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/ads/create.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");

        long userId = user.getId();
        String cat_id = request.getParameter("category");
        long cat = Long.parseLong(cat_id);
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String location = request.getParameter("location");

        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }

        Ad ad = new Ad(
                user.getId(),
                cat,
                request.getParameter("title"),
                request.getParameter("description"),
                request.getParameter("location")
        );

        DaoFactory.getAdsDao().update(ad);
        response.sendRedirect("/ads");
    }
}