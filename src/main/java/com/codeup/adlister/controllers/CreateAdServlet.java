package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import static java.lang.Long.parseLong;

@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/ads/create")
public class CreateAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if (request.getSession().getAttribute("user") == null) {
        response.sendRedirect("/login");
        return;
    }
    request.getRequestDispatcher("/WEB-INF/ads/create.jsp")
        .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");
        Ad ad = new Ad(
            user.getId(),
            request.getParameter("title"),
            request.getParameter("description")
        );
        long adId = DaoFactory.getAdsDao().insert(ad);
        String[] checkboxValues = request.getParameterValues("category");
        Category category1 = new Category();
        for(String category: checkboxValues){
            long newCategoryId = Long.parseLong(category);
            category1.setAdId(adId);
            category1.setId(newCategoryId);
            System.out.println(category);
            try {
                DaoFactory.getCatDao().insertAdCategories(category1);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }


        }
        response.sendRedirect("/ads");
    }
}
