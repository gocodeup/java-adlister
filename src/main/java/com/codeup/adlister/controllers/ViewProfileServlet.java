package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.MySQLUsersDao;
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
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }

//        String username = request.getSession().getAttribute("username").toString();
//        int user_id = (int)(DaoFactory.getUsersDao().findByUsername(username).getId());
//        request.setAttribute("ads", DaoFactory.getAdsDao().allFromUser(user_id));

        User username = (User) request.getSession().getAttribute("user");
        request.setAttribute("ads", MySQLUsersDao.findAdByUsername(username));
        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
    }
}
