package com.codeup.adlister.controllers;


import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "controllers.SearchAdsServlet", urlPatterns = "/ads/search")
public class SearchAdsServlet extends HttpServlet {

    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = request.getParameter("keyword");


//        boolean inputHasErrors = keyword.isEmpty();


        if (keyword.isEmpty()){
            response.sendRedirect("/ads");// needs the page to be redirected
            return;
        }

        List<Ad> ads = DaoFactory.getAdsDao().search(keyword);
        request.setAttribute("ads", ads);
//        System.out.println(ads);
        request.getRequestDispatcher("/WEB-INF/ads/search.jsp").forward(request,response);

    }

}
