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

//only able to create an ad if there is a session
//get the session and get the attribute of user to check if it is empty. If it is, then redirect to login
//else forward to create page
// also set the types attribute and display all types which will be used in the drop on on the jsp
@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/ads/create")
public class CreateAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }

        request.setAttribute("types", DaoFactory.getTypesDao().all());
        request.getRequestDispatcher("/WEB-INF/ads/create.jsp").forward(request, response);
    }

    // the session user will be equal to the attribute of the user that is logged in
    // create a new ad object and price will be validated
    //insert the ad and redirect to ads page
    //if validation fails then redirect back to create page
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");

        //validate price to make sure it is a double
        try {
            Ad ad = new Ad(
                    user.getId(),
                    request.getParameter("name"),
                    request.getParameter("description"),
                    Double.parseDouble(request.getParameter("price")),
                    request.getParameter("condition"),
                    request.getParameter("shiny"),
                    request.getParameter("type")
            );
            DaoFactory.getAdsDao().insert(ad);
            response.sendRedirect("/ads");
        } catch (NumberFormatException e) {
            response.sendRedirect("/ads/create");
            e.printStackTrace();
        }
    }
}