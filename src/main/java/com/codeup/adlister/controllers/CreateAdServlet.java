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
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

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
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        List<String> categoryList = Arrays.asList(request.getParameterValues("categoryCheckbox"));
        double price = Double.parseDouble(request.getParameter("price"));

        Ad ad = new Ad(
            user.getId(),
            title,
            description,
            price
        );

        int newAdId = DaoFactory.getAdsDao().insert(ad);
        for (String cat : categoryList) {
            try {
                DaoFactory.getAdsDao().addtoAdCategoryTable(newAdId, Integer.parseInt(cat));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        response.sendRedirect("/ads");
    }
}
