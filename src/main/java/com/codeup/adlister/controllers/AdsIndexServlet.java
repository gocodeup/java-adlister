package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.Ads;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.UserAds;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "controllers.AdsIndexServlet", urlPatterns = "/ads")
public class AdsIndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie message = new Cookie("message", "Welcome to the ads page.");
        request.setAttribute("ads", DaoFactory.getAdsDao().all());
        request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);
//        response.addCookie(message);
    }

//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
////        int id = Integer.parseInt(request.getQueryString());
//////        String id = request.getQueryString();
////        request.setAttribute("ad", DaoFactory.getAdsDao().thisAdById(id));
//
//        //        Long id = Long.parseLong(request.getQueryString());
////        request.setAttribute("ad", DaoFactory.getAdsDao().thisAdById(id));
////        if (request.getSession().getAttribute("ads") == null) {
////            response.sendRedirect("/ads");
////        }
////        else if (request.getSession().getAttribute("id") == null) {
////            response.sendRedirect("/search");
////        }
////            else {
////            Cookie message = new Cookie("message", "Welcome to a specific ad page.");
////            request.setAttribute("ads", DaoFactory.getAdsDao().thisAd((Long) request.getSession().getAttribute("id")));
////            response.addCookie(message);
//
//
//        request.getRequestDispatcher("/WEB-INF/AdLanding.jsp").forward(request, response);
////        }
//    }


}
