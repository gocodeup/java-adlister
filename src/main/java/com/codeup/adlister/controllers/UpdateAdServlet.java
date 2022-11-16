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
    long id;
  String oldDescription;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

     titleOld = request.getParameter("title");
     id = Long.parseLong(request.getParameter("id"));
        oldDescription = request.getParameter("description");


        request.getRequestDispatcher("/WEB-INF/ads/updateAd.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");

String title = request.getParameter("title");
        if( title.isEmpty()){title = titleOld;}

String description =  request.getParameter("description");
        if( description.isEmpty()){ description = oldDescription;}




        System.out.println(id);
        System.out.println(oldDescription);
      Ad ad =  DaoFactory.getAdsDao().ById(id);  //FIND THE AD TO UPDATE
        DaoFactory.getAdsDao().update(ad,title,description);    // UPDATE AD
        response.sendRedirect("/ads");

    }
}
