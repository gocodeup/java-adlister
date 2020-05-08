package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "controllers.UpdateAdServlet", urlPatterns = "/update")
public class UpdateAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }

        Long id = Long.parseLong(request.getParameter("id"));

        request.setAttribute("ad", DaoFactory.getAdsDao().findAdById(id));
        request.setAttribute("types", DaoFactory.getTypesDao().all());
        request.getRequestDispatcher("/WEB-INF/ads/update.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");

        try {
            Ad ad = new Ad(
                    Long.parseLong(request.getParameter("id")),
                    user.getId(),
                    request.getParameter("name"),
                    request.getParameter("description"),
                    Double.parseDouble(request.getParameter("price")),
                    request.getParameter("shiny"),
                    request.getParameter("type"),
                    request.getParameter("imageURL")
            );

            DaoFactory.getAdsDao().update(ad);
            response.sendRedirect("/profile");
        } catch (NumberFormatException e) {
            response.sendRedirect("/update?id=" + Long.parseLong(request.getParameter("id")));
        }
    }
}

