package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/update")
public class DeleteAdServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        String adid = (String) request.getSession().getAttribute("delAdId");
        int deladID = Integer.parseInt(adid);

        int allCat = DaoFactory.getCategoriesDao().deleteCategoriesPerAd(deladID);

        DaoFactory.getAdsDao().deleteAd(deladID);

        response.sendRedirect("/ads");
    }
}