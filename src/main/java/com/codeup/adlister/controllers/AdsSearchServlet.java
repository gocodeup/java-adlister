package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "controllers.AdsSearchServlet", urlPatterns = "/ads/search")
public class AdsSearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String search = request.getParameter("search");
        try{
            request.setAttribute("ads", DaoFactory.getAdsDao().findAdsByName(search));
            request.getRequestDispatcher("/WEB-INF/ads/viewsearch.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

