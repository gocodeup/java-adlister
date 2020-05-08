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

@WebServlet(name = "controllers.AdsFilterServlet", urlPatterns = "/ads/filter")
public class AdsFilterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String filter = request.getParameter("type");
        try{
            request.setAttribute("ads", DaoFactory.getAdsDao().findAdsByType(filter));
            request.setAttribute("type", filter);
            request.getRequestDispatcher("/WEB-INF/ads/viewfilter.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

