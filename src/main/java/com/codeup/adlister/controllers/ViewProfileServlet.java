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
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "controllers.ViewProfileServlet", urlPatterns = "/profile")
public class ViewProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }

//
//        User user = (User) request.getSession().getAttribute("id");
//        if (user == user_id){
//
//        }
//        if (request.getSession().getAttribute(user.getUsername()){
//
//        }

        request.setAttribute("ads", DaoFactory.getAdsDao().all());

        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
    }

    //what to look for and how to get there - methods

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
//

//        Ad userAd = new Ad(
//                user.getId(),
//                request.getParameter("title"),
//                request.getParameter("description"),
//                request.getParameter("category")
//        );
//
//        DaoFactory.getAdsDao().insert(userAd);
//
//        if (userAd.getUserId() == DaoFactory.getAdsDao().userSpecificPost()){
//
//        }
//        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
//    }
}
