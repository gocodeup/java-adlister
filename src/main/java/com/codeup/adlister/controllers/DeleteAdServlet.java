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
import java.io.PrintWriter;

@WebServlet(name = "controllers.DeleteAdServlet", urlPatterns = "/ads/delete")
public class DeleteAdServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");
        String selected = request.getQueryString();
        Ad ad = DaoFactory.getAdsDao().findById(selected);

    }
}
