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

@WebServlet(name = "controllers.AdSearchServlet", urlPatterns = "/search")
public class AdSearchServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("user") == null){
            response.sendRedirect("/register");
        } else {
            response.sendRedirect("/ads");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        if(request.getSession().getAttribute("user") == null){
            response.sendRedirect("/register");
        } else {
            if (DaoFactory.getAdsDao().adTitlePick(request.getParameter("title")) != null) {
                Ad ad = DaoFactory.getAdsDao().adTitlePick(request.getParameter("title"));
                User user = DaoFactory.getUsersDao().findByUserId(ad.getUserId());
                request.setAttribute("ad", ad);
                request.setAttribute("adUser", user);
                request.getRequestDispatcher("/WEB-INF/ads/ad.jsp").forward(request, response);

            } else {
                response.sendRedirect("/ads");
            }
        }

}
}