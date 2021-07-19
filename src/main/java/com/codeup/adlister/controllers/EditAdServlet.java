package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "EditAdServlet", urlPatterns = "/ads/edit")
public class EditAdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id;
        try {
            id = Long.parseLong(request.getParameter("id"));
        } catch (NumberFormatException e) {
            Ad adToEdit = (Ad) request.getAttribute("ad");
            id = adToEdit.getId();

        }

        Ad ad = DaoFactory.getAdsDao().getAdById(id);

        if (ad == null) {
            response.sendRedirect("/ads");
            return;
        }

        String title = request.getParameter("title");
        String description = request.getParameter("description");
        HashMap<String, String> errors = new HashMap<>();

        if (title == null || title.trim().isEmpty()) {
            errors.put("title", "title cannot be empty");
        }

        if (description == null || description.trim().isEmpty()) {
            errors.put("description", "description cannot be empty");
        }

        if(errors.size() > 0) {
            request.setAttribute("adErrors", errors);
            request.setAttribute("ad", ad);
            request.getRequestDispatcher("/WEB-INF/editAd.jsp?id=" + id).forward(request, response);

            return;
        }

        ad.setTitle(title);
        ad.setDescription(description);
        DaoFactory.getAdsDao().updateAd(ad);

        response.sendRedirect("/profile");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        Ad ad = DaoFactory.getAdsDao().getAdById(id);
        request.setAttribute("ad", ad);
        request.getRequestDispatcher("/WEB-INF/editAd.jsp").forward(request, response);
    }
}
