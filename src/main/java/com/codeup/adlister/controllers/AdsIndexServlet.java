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

@WebServlet(name = "controllers.AdsIndexServlet", urlPatterns = {"/ads", "/searchAds"})
public class AdsIndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchDescription = request.getParameter("description");
        request.setAttribute("ads", DaoFactory.getAdsDao().getAds(searchDescription));
        request.setAttribute("heading", "The user searched for " + searchDescription);
       request.getRequestDispatcher("/WEB-INF/ads/index.jsp" ).forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("ads", DaoFactory.getAdsDao().all());
        request.setAttribute("heading", "Display all of the ads");
        request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);

    }

}


