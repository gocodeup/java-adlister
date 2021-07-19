
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



@WebServlet("/search")
public class SearchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String query = req.getParameter("s");
        String userSearch = req.getParameter(query);
        List<Ad> results = DaoFactory.getAdsDao().searchByTitle(query);
        req.setAttribute("query", query);
        req.setAttribute("ads", results);
        req.getRequestDispatcher("/WEB-INF/ads/search.jsp").forward(req, resp);
        boolean emptySearch = userSearch.isEmpty();
        if (emptySearch) {
            resp.sendRedirect("/ads");
        } else {
            DaoFactory.getAdsDao().searchByTitle(query);
        }

    }
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String query = req.getParameter("query");
//        String userSearch = req.getParameter(query);
//        List<Ad> results = DaoFactory.getAdsDao().searchByTitle(query);
//        req.setAttribute("query", query);
//        req.setAttribute("ads", results);
//        req.getRequestDispatcher("/WEB-INF/ads/search.jsp").forward(req, resp);
//        boolean emptySearch = userSearch.isEmpty();
//        if (emptySearch) {
//            resp.sendRedirect("/ads");
//        } else {
//            DaoFactory.getAdsDao().searchByTitle(query);
//        }
//    }

}

