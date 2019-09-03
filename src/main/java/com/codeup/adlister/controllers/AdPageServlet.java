package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.AdPageServlet", urlPatterns = "/ad/*")
public class AdPageServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getQueryString());
        request.setAttribute("ad", DaoFactory.getAdsDao().thisAdById(id));

        System.out.println(request.getAttribute("ad"));
        request.getRequestDispatcher("/WEB-INF/AdLanding.jsp").forward(request, response);
    }
}
