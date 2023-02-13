package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet(name = "SearchServlet", urlPatterns = "/ads/search")
public class SearchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchString = req.getParameter("s");

        try{
            List<Ad> adlist =DaoFactory.getAdsDao().searchAds(searchString);
            req.setAttribute("ads", adlist);
        } catch (SQLException e){
            throw new RuntimeException("Error");
        }

        req.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(req, resp);
    }
}
