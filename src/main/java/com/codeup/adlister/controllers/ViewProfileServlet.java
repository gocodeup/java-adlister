package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "controllers.ViewProfileServlet", urlPatterns = "/profile")
public class ViewProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }

        HttpSession session = request.getSession();
        System.out.println("request.getSession().getAttribute(\"user\") = " + request.getSession().getAttribute("user"));

//        request.setAttribute("ads", DaoFactory.getAdsDao().getAdsByUserId(liuID));
//
//        System.out.println("loggedInUser = " + loggedInUser);
//        System.out.println("liuID = " + liuID);

        System.out.println("request.getAttribute(\"userId\") = " + request.getSession().getAttribute("userId"));

        Long currentlyLoggedInUserId = Long.parseLong(String.valueOf(request.getSession().getAttribute("userId")));

        request.setAttribute("ads", DaoFactory.getAdsDao().getAdsByUserId(currentlyLoggedInUserId));


        System.out.println("request.getSession().getAttribute(\"ads\") = " + request.getSession().getAttribute("ads"));

        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);


    }


}
