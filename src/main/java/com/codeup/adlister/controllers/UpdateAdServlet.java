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
        System.out.println(request.getParameter("id"));
        request.getRequestDispatcher("/WEB-INF/ads/update.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Storing user input values from update form.

        String title = request.getParameter("title");
        String description = request.getParameter("description");
        System.out.println(title);
        System.out.println(description);
        Long id = Long.valueOf(request.getParameter("id"));
        System.out.println(id);

        //TODO: Get id from ad.
        // When submitting POST request, it currently returns the id as null.
        DaoFactory.getAdsDao().updateAd(id, title, description);

    }
}
