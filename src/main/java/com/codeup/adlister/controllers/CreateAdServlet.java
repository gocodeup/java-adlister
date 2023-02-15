package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.*;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
        request.setAttribute("categories", DaoFactory.getCategoryDao().all());
        request.getRequestDispatcher("/WEB-INF/ads/create.jsp")
            .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User user = (User) request.getSession().getAttribute("user");
        Ad ad = new Ad(
            user.getId(),
            request.getParameter("title"),
            request.getParameter("description")
        );
        if(DaoFactory.getAdsDao().findByTitle(ad.getTitle()) == null){
            DaoFactory.getAdsDao().insert(ad);
            List<Ad> returnedAds = DaoFactory.getAdsDao().myAds(user);
            String returnedAd = null;
            for (Ad current : returnedAds){
                if(Objects.equals(current.getTitle(), request.getParameter("title"))){
                    returnedAd = String.valueOf(current.getId());
                }
            }
            String[] recievedCats = request.getParameterValues("category");
            if(recievedCats != null){
                for( String cat : recievedCats){
                    AdCat adCat = new AdCat(Integer.parseInt(cat) , Integer.parseInt(returnedAd));
                    DaoFactory.getAdCatsDao().insert(adCat);
                }
            }
            response.sendRedirect("/ads/ad?"+returnedAd);
        }
        else{
            request.setAttribute("error", new JSON("Please change the title, no duplicates allowed"));
            request.setAttribute("ad", ad);
            request.getRequestDispatcher("/WEB-INF/ads/create.jsp").forward(request, response);
        }
    }
}
