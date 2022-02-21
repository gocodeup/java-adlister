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
import java.sql.SQLException;

@WebServlet(name = "controllers.IndividualAdServlet", urlPatterns = "/ads/individualAd")
public class IndividualAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        long individualAd = Long.parseLong(request.getParameter("ad"));
        User user = DaoFactory.getUsersDao().findByAd(individualAd);
        //Ad ad = DaoFactory.getAdsDao().findById(individualAd);
        request.setAttribute("ad", DaoFactory.getAdsDao().findById(individualAd));
        request.setAttribute("userAd", user.getUsername());
        request.getRequestDispatcher("/WEB-INF/ads/ShowIndvAd.jsp").forward(request, response);

    }
}
