package com.codeup.adlister.controllers;


import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "delete", urlPatterns = "/ads/delete")
public class AdDeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        long id = Long.parseLong(request.getParameter("id"));
        request.setAttribute("ad", DaoFactory.getAdsDao().findById(id));
        request.getRequestDispatcher("/WEB-INF/ads/delete.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");
        String password = request.getParameter("password");

        long id = Long.parseLong(request.getParameter("id"));

        if (Password.check(password, user.getPassword())) {
            DaoFactory.getAdsDao().deleteAd((int) id);
            request.setAttribute("message", "Your ad has been deleted successfully");
            response.sendRedirect("/profile");
        } else {
            response.sendRedirect("/profile");
        }
    }
}

