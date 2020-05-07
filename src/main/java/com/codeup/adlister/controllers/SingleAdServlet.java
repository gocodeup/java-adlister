package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.ListAdsDao;
import com.codeup.adlister.dao.MySQLAdsDao;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.SingleAdServlet", urlPatterns = "/ads/view?id=2")
public class SingleAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        long id = Long.parseLong(idStr);

        Ad ad = DaoFactory.getAdsDao().getById(id);

        request.setAttribute("ad", ad);
        System.out.println(ad);
        request.getRequestDispatcher("/WEB-INF/ads/single_ad.jsp").forward(request, response);
    }
}
