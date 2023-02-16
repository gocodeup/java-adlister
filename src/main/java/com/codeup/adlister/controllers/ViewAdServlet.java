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


@WebServlet(name = "controllers.ViewAdServlet", urlPatterns = "/ads/ad")
public class ViewAdServlet extends HttpServlet{
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            User user = (User) request.getSession().getAttribute("user");
            String selected = request.getParameter("query");
            if(selected == null){
                selected = request.getQueryString();
            }
            if(user == null){
                response.sendRedirect("/login?"+selected);
            }
            else{
                Ad returned = DaoFactory.getAdsDao().findById(selected);
                User owner = DaoFactory.getUsersDao().findById(String.valueOf(returned.getUserId()));
                request.setAttribute("ad", returned);
                request.setAttribute("owner", owner);
                request.getRequestDispatcher("/WEB-INF/ads/showAd.jsp").forward(request, response);
            }

        }

}

