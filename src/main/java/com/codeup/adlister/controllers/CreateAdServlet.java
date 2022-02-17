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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/ads/create")
public class CreateAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        List <Category> allCategories = DaoFactory.getCategoriesDao().all();
        request.getSession().setAttribute("allCategories",allCategories);

        request.getRequestDispatcher("/WEB-INF/ads/create.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");
        String title = request.getParameter("title");
        String description = request.getParameter("description");

        String [] selectedCategories = request.getParameterValues("categoryCheckbox");
        List<Category> categoryObjects = new ArrayList<>();
        for (int i = 0; i < selectedCategories.length; i++) {
            categoryObjects.add(DaoFactory.getCategoriesDao().getCategoryByCatName(selectedCategories[i]));
        }


        //if title or description is missing error message will be created
        if (title.isEmpty() || description.isEmpty()) {
            String errorMessage = "Missing information.";
            //errorMessage variable is set to attribute createError
            request.getSession().setAttribute("createError", errorMessage);
            //user is redirected to create page
            response.sendRedirect("/ads/create");
        } else {
            //when all conditions are met new ad is created
            Ad ad = new Ad(
                    user.getId(),
                    request.getParameter("title"),
                    request.getParameter("description")

            );
            DaoFactory.getAdsDao().insert(ad);
            response.sendRedirect("/ads");
        }

    }
}
