//package com.codeup.adlister.controllers;
//
//import com.codeup.adlister.dao.DaoFactory;
//import com.codeup.adlister.models.Ad;
//import com.codeup.adlister.models.User;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebServlet(name = "controllers.AdsIndexServlet", urlPatterns = "/ads")
//public class AdsSearchServlet extends HttpServlet {
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setAttribute("ads", DaoFactory.getAdsDao().all());
//        request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);
//
//        String searchQuery = request.getParameter("search");
//        System.out.println(searchQuery);
//        Ad search = (Ad) DaoFactory.getAdsDao().findByTitle(searchQuery);
//    }
//}
