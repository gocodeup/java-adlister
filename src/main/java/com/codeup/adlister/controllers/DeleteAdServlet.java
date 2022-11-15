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

@WebServlet(name = "DeleteAdServlet", urlPatterns = "/deleteAd")
public class DeleteAdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") != null) {
            long adId = Long.parseLong(req.getParameter("id"));
            DaoFactory.getAdsDao().deleteAd(adId);
            req.getRequestDispatcher("WEB-INF/ads/index.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/login");
        }
    }

}