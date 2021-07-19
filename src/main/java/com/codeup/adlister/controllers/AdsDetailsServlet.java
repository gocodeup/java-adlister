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
import java.util.List;

@WebServlet(name = "AdsDetailServlet", urlPatterns = "/ad")
public class AdsDetailsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        long id = Long.parseLong(request.getParameter("id"));
        Ad ad = DaoFactory.getAdsDao().getAdById(id);
        DaoFactory.getAdsDao().deleteAd(ad);

        response.sendRedirect("/profile");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        long id = Long.parseLong(request.getParameter("id"));
        List<String> categories = DaoFactory.getCatDao().printCategories(id);
        for(String cat: categories){
            System.out.println(cat);
        }

        Ad viewAdInfo = DaoFactory.getAdsDao().getAdById(id);
        request.setAttribute("viewAdInfo", viewAdInfo);

        User viewUserInfo = DaoFactory.getUsersDao().findById(viewAdInfo.getUserId());
        request.setAttribute("viewUserInfo", viewUserInfo);
        request.setAttribute("categories", categories);


        request.getRequestDispatcher("/WEB-INF/ads/ad-details.jsp").forward(request, response);
    }
}
