package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.MySQLUsersDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "controllers.ViewAdServlet", urlPatterns = "/ad/")
public class ViewAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adId = request.getQueryString();
        String[] args = request.getQueryString().split("=");
        Long id = Long.parseLong(args[1]);
        request.setAttribute("ad", DaoFactory.getAdsDao().getAdById(id));

        System.out.println(request.getAttribute("ad"));
        request.getRequestDispatcher("/WEB-INF/adShowPage.jsp").forward(request, response);
    }
}