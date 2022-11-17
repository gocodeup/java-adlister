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

@WebServlet(name = "controllers.UpdateAdServlet", urlPatterns = "/ads/update")
public class UpdateAdServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }

        request.setAttribute("adId", request.getParameter("id"));
        request.getRequestDispatcher("/WEB-INF/ads/update.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Storing user input values from update form.
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        Long id = Long.valueOf(request.getParameter("adId"));


        // Using DAO factory to access our update method.
        DaoFactory.getAdsDao().updateAd(id, title, description);

        // Redirecting user to ads page after submitting update form.
        response.sendRedirect("/ads");
    }
}
