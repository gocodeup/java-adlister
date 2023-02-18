package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.ReturnedCats;
import com.codeup.adlister.models.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "controllers.SearchServlet", urlPatterns = "/ads/search")
public class SearchServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("ads", DaoFactory.getAdsDao().all());
        request.setAttribute("categories", DaoFactory.getCategoryDao().all());
        request.getRequestDispatcher("/WEB-INF/ads/Search.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ReturnedCats> returnedCats = new ArrayList<>();
        String[] recievedCats = request.getParameterValues("category");
        if(recievedCats != null){
            for (String cat : recievedCats){
                returnedCats.add(new ReturnedCats(cat));
            }
        }

        String words = request.getParameter("words");



        request.setAttribute("ads", DaoFactory.getAdsDao().searchResults(words, returnedCats));
        request.setAttribute("words", words);
        request.setAttribute("categories", DaoFactory.getCategoryDao().all());
        request.setAttribute("checked", returnedCats);
        request.getRequestDispatcher("/WEB-INF/ads/Search.jsp").forward(request, response);
    }

}

