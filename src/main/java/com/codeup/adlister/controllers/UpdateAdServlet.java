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

@WebServlet(name = "controllers.UpdateAdServlet", urlPatterns = "/updateAd")
public class UpdateAdServlet extends HttpServlet {
    String titleOld;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

     titleOld = request.getParameter("title");

        request.getRequestDispatcher("/WEB-INF/ads/updateAd.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");

String title = request.getParameter("title");
String description = request.getParameter("description");

        System.out.println(titleOld);
      Ad ad =  DaoFactory.getAdsDao().ByTitle(titleOld);  //FIND THE AD TO UPDATE
        DaoFactory.getAdsDao().update(ad,title,description);    // UPDATE AD
        response.sendRedirect("/ads");

    }
}
