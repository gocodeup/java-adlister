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

        String [] selectedCategories = request.getParameterValues("categoryCheckbox");
        for (int i = 0; i < selectedCategories.length; i++) {
            System.out.println(selectedCategories[i]);
        }
        List <Category> allCategories = DaoFactory.getCategoriesDao().all();
        for (int i = 0; i < allCategories.size(); i++) {
            allCategories.get(i).getCategory().equalsIgnoreCase(selectedCategories[i]);
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

            Long IDofNewAd = DaoFactory.getAdsDao().insert(ad);
            if (request.getParameter("clothing") != null) {
                DaoFactory.getAdsDao().getAdsFromCategory(IDofNewAd, 2L);
            }
            if (request.getParameter("electronics-media") != null) {
                DaoFactory.getAdsDao().getAdsFromCategory(IDofNewAd, 1L);
            }
            ;
            if (request.getParameter("vehicles") != null) {
                DaoFactory.getAdsDao().getAdsFromCategory(IDofNewAd, 3L);
            }
            if (request.getParameter("sporting-goods") != null) {
                DaoFactory.getAdsDao().getAdsFromCategory(IDofNewAd, 4L);
            }
            if (request.getParameter("pets") != null) {
                DaoFactory.getAdsDao().getAdsFromCategory(IDofNewAd, 5L);
            }

            //clear title & description attribute Because worked and no longer want to be filled in -CG
            request.getSession().setAttribute("title", null);
            request.getSession().setAttribute("description", null);

            response.sendRedirect("/ads");
        }

    }
}
