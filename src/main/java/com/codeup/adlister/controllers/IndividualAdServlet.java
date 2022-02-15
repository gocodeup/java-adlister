package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.IndividualAdServlet", urlPatterns = "/ads/individualAd")
public class IndividualAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long individualAd = Long.parseLong(request.getParameter("loneAd"));
        DaoFactory.getAdsDao().individualAd(individualAd);
        request.setAttribute("loneAd", DaoFactory.getAdsDao().individualAd(individualAd));


        request.getRequestDispatcher("/WEB-INF/ShowIndvAd.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }
}
