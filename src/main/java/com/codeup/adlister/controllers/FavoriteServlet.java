package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "controllers.FavoriteServlet", urlPatterns = "/ads/favorite")
public class FavoriteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adId = request.getQueryString();
        User user = (User) request.getSession().getAttribute("user");
        List<Ad> favList = DaoFactory.getFavoritesDao().getRelated(user);
        boolean fav = false;
        for (Ad ad : favList){
            if (Objects.equals(String.valueOf(ad.getId()) , adId)) {
                fav = true;
                break;
            }
        }
        if(fav){
            DaoFactory.getFavoritesDao().deleteAdFav(adId);
            response.sendRedirect("/ads");
        }
        else{
            DaoFactory.getFavoritesDao().addAdFav(adId,user);
            response.sendRedirect("/profile");
        }




    }
}
