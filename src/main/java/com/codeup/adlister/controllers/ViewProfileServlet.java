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
import java.util.List;
@WebServlet(name = "controllers.ViewProfileServlet", urlPatterns = "/profile")
public class ViewProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        Long userId = user.getId();
        System.out.println(user.getId());
        List<Ad> ads = DaoFactory.getAdsDao().findPostByUserId(userId);

        request.setAttribute("ads", ads);




        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;


        }
        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);

    }

}

