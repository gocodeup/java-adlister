package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.ShowCategoriesServlet", urlPatterns = "/categories")
public class ShowCategoriesServlet extends HttpServlet {

//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // request for all categories to populate the categories.jsp page
//        request.setAttribute("categories", DaoFactory.getCategoriesDao().all());
//
//
//        // request so that specific category populates the categories.jsp page
//        String categoryTitle = request.getParameter("categories");
//        request.setAttribute("categories", DaoFactory.getCategoriesDao().getCategoryByCatName(categoryTitle));
//
//        request.getRequestDispatcher("/WEB-INF/ads/categories.jsp").forward(request, response);
//    }
}
