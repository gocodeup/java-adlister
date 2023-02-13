package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.JSON;
import com.codeup.adlister.models.User;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/ads/create")
public class CreateAdServlet extends HttpServlet {

    private Gson gson = new Gson();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/ads/create.jsp")
            .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");
        Ad ad = new Ad(
            user.getId(),
            request.getParameter("title"),
            request.getParameter("description")
        );
        DaoFactory.getAdsDao().insert(ad);

        List<Ad> returnedAds = DaoFactory.getAdsDao().myAds(user);
        String returnedAd = null;
        for (Ad current : returnedAds){
            if(Objects.equals(current.getTitle(), request.getParameter("title"))){
                returnedAd = String.valueOf(current.getId());
            }
        }

        PrintWriter out = response.getWriter();
        String jsonString;
        JSON json = new JSON("Your Ad labeled "+ ad.getTitle() +" was added", "/ads/ad?"+returnedAd);
        jsonString = this.gson.toJson(json);
        out.print(jsonString);
        out.flush();
    }
}
