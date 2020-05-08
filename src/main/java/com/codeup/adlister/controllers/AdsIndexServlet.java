package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "controllers.AdsIndexServlet", urlPatterns = "/ads")
public class AdsIndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<String> users = new ArrayList<>();
        List<Ad> adShrink = DaoFactory.getAdsDao().all();
        for(long i = 0; i <= adShrink.size() - 1; i++){
            users.add(DaoFactory.getUsersDao().findByUserId(adShrink.get((int) i).getUserId()).getUsername());
        }
        request.setAttribute("ads", adShrink);
        request.setAttribute("users", users);
        request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);
    }



}
