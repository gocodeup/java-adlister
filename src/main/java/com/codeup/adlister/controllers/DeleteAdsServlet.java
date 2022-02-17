package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteAdsServlet", value = "/ads/delete")
public class DeleteAdsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        long id = Long.parseLong(request.getParameter("ad_id"));
        DaoFactory.getAdsDao().deleteCategories(id);
        DaoFactory.getAdsDao().delete(id);
        response.sendRedirect("/profile");
    }
}
