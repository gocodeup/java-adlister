package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.Config;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "controllers.UpdateAdServlet", urlPatterns = "/ads/update")
public class UpdateAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long adId = Long.parseLong(request.getParameter("adId"));
        Ad ad = DaoFactory.getAdsDao().findUniqueAdId(adId);
        request.setAttribute("ad", ad);
        request.getRequestDispatcher("/WEB-INF/ads/update.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            if (request.getParameter("editButton") != null) {

                // Edit Process
                long adId = Long.parseLong(request.getParameter("adId"));
                Ad editAd = DaoFactory.getAdsDao().findUniqueAdId(adId);
                String title = request.getParameter("title");
                String description = request.getParameter("description");
                    editAd.setTitle(title);
                    editAd.setDescription(description);
                    DaoFactory.getAdsDao().update(editAd);

            }
            if (request.getParameter("delete-ad") != null) {

            // Edit Process
                long adId = Long.parseLong(request.getParameter("adId"));
                Ad deleteAd = DaoFactory.getAdsDao().findUniqueAdId(adId);
                DaoFactory.getAdsDao().delete(deleteAd);
        }
            response.sendRedirect("/ads");
        }

    }

