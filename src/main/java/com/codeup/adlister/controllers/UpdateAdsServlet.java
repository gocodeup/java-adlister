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

@WebServlet(name = "controllers.UpdateAdsServlet", urlPatterns = "/ads/updateads")
public class UpdateAdsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }

        String errorMessage = request.getParameter("errorMessage");
        request.setAttribute("errorMessage", errorMessage);

        long ad_id = Long.parseLong(request.getParameter("ad_id"));
        Ad ad = DaoFactory.getAdsDao().findById(ad_id);

        request.setAttribute("ad_id", request.getParameter("ad_id"));
        request.setAttribute("title", ad.getTitle());
        request.setAttribute("description", ad.getDescription());
        request.getRequestDispatcher("/WEB-INF/ads/updateads.jsp").forward(request, response);

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String updateTitle = request.getParameter("updateTitle");
        String updateDescription = request.getParameter("updateDescription");
        long updateID = Long.parseLong(request.getParameter("ad_id"));

        if(updateTitle == null || updateTitle.isEmpty()){
            response.sendRedirect("/ads/updateads?ad_id=" + updateID+ "&errorMessage=TitleNull");
            return;
        }

        if(updateDescription == null || updateDescription.isEmpty()){
            response.sendRedirect("/ads/updateads?ad_id=" + updateID+ "&errorMessage=DescriptionNull");
            return;
        }

        User user = (User) request.getSession().getAttribute("user");
        Ad ad = new Ad(updateID, user.getId(),updateTitle, updateDescription);
        DaoFactory.getAdsDao().update(ad);
        response.sendRedirect("/profile");
    }
}