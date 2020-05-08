package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "controllers.AdSearchServlet", urlPatterns = "/search")
public class AdSearchServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        request.getRequestDispatcher("/WEB-INF/ads.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {


        ArrayList<String> users = new ArrayList<>();
        System.out.println(request.getParameter("title"));
        List<Ad> ads = DaoFactory.getAdsDao().getByTitle(request.getParameter("title"));
        System.out.println(ads);
        if (ads == null || ads.isEmpty() || request.getParameter(
                "title").isEmpty()) {
            request.getSession().setAttribute("errorMessage", "An ad with that title doesn't exist.");
            response.sendRedirect("/ads");
            return;
        } else {
            for (Ad ad : ads) {
                users.add(DaoFactory.getUsersDao().findByUserId(ad.getUserId()).getUsername());
            }
            request.setAttribute("ads", ads);
            request.setAttribute("users", users);
            request.getRequestDispatcher("/WEB-INF/ads/ad.jsp").forward(request, response);

        }
    }
}
