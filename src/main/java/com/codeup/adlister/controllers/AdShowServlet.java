package com.codeup.adlister.controllers;


import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name ="controllers.AdShowServlet", urlPatterns = "/ads/show")
public class AdShowServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        long adId = Long.parseLong(request.getParameter("id"));
        long userId = Long.parseLong(request.getParameter("userId"));
        request.setAttribute("ad", DaoFactory.getAdsDao().showAd(adId));
        request.setAttribute("user", DaoFactory.getUsersDao().findByUserId(userId));
        request.getRequestDispatcher("/WEB-INF/ads/showAd.jsp").forward(request,response);
    }
}
