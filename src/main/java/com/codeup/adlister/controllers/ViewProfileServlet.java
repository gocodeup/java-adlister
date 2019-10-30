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
        String user = request.getSession().getAttribute("user").toString();

        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");

            return;
        }
        User uID = (User) request.getSession().getAttribute("user");
//            I want what ever ad this user created to display on the user's profile.
//            need to take in any info from the "/ads" and somehow transfer to user's profile
//            now, how do i do that?!

        request.setAttribute("ads", DaoFactory.getAdsDao().findAdByUserId(uID));

        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
    }
}