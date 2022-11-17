package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.IndividualAdServlet", urlPatterns = "/ads/singles")
public class SingleAdServlet  extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        long ad_id = Long.parseLong(req.getParameter("ad_id"));
        Ad ad = (Ad) DaoFactory.getAdsDao().findByID(ad_id);
        System.out.println(ad_id);
        System.out.println(ad);
        req.setAttribute("singleAd", ad);
        req.getRequestDispatcher("/WEB-INF/ads/single-ad.jsp").forward(req, resp);
    }
}
