package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.ViewProfileServlet", urlPatterns = "/profile")
public class ViewProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect("/login");
            return;
        }
        System.out.println(DaoFactory.getFavoritesDao().getRelated(user).size());

        request.setAttribute("myFavs", DaoFactory.getFavoritesDao().getRelated(user));
        request.setAttribute("myAds", DaoFactory.getAdsDao().myAds(user));
        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
    }
}
