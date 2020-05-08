package com.codeup.adlister.controllers;

//import com.codeup.adlister.dao.DaoFactory;
//import com.codeup.adlister.models.Ad;
//import com.codeup.adlister.models.User;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//import java.sql.SQLException;

@WebServlet(name = "editAd", urlPatterns = "/ad/update")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/update.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String newName = request.getParameter("adName");
        String newDescription = request.getParameter("adDescription");
        long id = Long.parseLong(request.getParameter("id"));
        long cat_id = Long.parseLong(request.getParameter("cat_id"));

        DaoFactory.getAdsDao().updateAd(newName, newDescription, cat_id, id);
        response.sendRedirect("/ads");
    }
}
