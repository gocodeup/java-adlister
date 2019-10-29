package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.SearchResultsServlet", urlPatterns = "/search")
public class SearchResultsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().println("GET to the search page");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String s = request.getParameter("search");

        request.setAttribute("ads", DaoFactory.getAdsDao().adsTitleQuery(s));
        request.setAttribute("searchQuery", s);

        request.getRequestDispatcher("/WEB-INF/ads/results.jsp").forward(request, response);

    }
}
