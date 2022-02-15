package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "IndividualAdServlet", urlPatterns = "/ads/individualAd")
public class IndividualAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long individualAd = Long.parseLong(request.getParameter("loneAd"));
        Ad ad = DaoFactory.getAdsDao().findById(individualAd);
        request.setAttribute("ad", ad);
        request.getRequestDispatcher("/WEB-INF/ads/ShowIndvAd.jsp").forward(request, response);
    }
}
