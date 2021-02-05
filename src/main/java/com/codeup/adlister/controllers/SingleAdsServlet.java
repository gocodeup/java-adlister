package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//display one ad on the page
//get the id using getParameter and parse it
//set the attribute of ad, and find an ad by id using the long id
//forward to single ad page
@WebServlet(name = "controllers.SingleAdsServlet", urlPatterns = "/ad")
public class SingleAdsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id =Long.parseLong(request.getParameter("id"));
        request.setAttribute("ad", DaoFactory.getAdsDao().findAdById(id));
        request.getRequestDispatcher("/WEB-INF/ads/singlead.jsp").forward(request, response);
    }
}