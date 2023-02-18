package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.JSON;
import com.codeup.adlister.models.User;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet(name = "controllers.DeleteAdServlet", urlPatterns = "/ads/delete")
public class DeleteAdServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String lastPlace = request.getHeader("Referer");
        User user = (User) request.getSession().getAttribute("user");
        String selected = request.getQueryString();
        Ad returned = DaoFactory.getAdsDao().findById(selected);
        User owner = DaoFactory.getUsersDao().findById(String.valueOf(returned.getUserId()));
        if(owner.getId() == user.getId()){
            DaoFactory.getAdsDao().deleteAd(selected);
            response.sendRedirect(lastPlace);
        }
        else{
            request.setAttribute("ad", returned);
            request.setAttribute("error", new JSON("Did not find relation to you and ad"));
            request.getRequestDispatcher("/WEB-INF/ads/showAd.jsp").forward(request, response);

        }

    }
}
