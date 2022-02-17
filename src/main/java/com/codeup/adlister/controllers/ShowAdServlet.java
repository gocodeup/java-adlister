package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.Ads;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ad")
public class ShowAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        String adId = req.getParameter("id");
        req.setAttribute("id", adId);
//        try {
//            Ad adsDao = DaoFactory.getAdsDao().findOne(id);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        if(adId != null){
//
//        }

//      need to get id of ad
        //  here we will bring in DaoFactory here to getAdById()
//      need to set id of ad to "ad"
//      req.setAttribute("ad", id)
        req.getRequestDispatcher("/WEB-INF/ads/showAd.jsp").forward(req, res);
    }

    public static void main(String[] args) {

    }
}
