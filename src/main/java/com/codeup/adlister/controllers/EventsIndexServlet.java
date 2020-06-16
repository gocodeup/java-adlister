package com.codeup.adlister.controllers;
import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.EventsIndexServlet", urlPatterns = "/events")
public class EventsIndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("ads", DaoFactory.getAdsDao().all());
//        if (request.getSession().getAttribute("events").equals("events")){
//            response.sendRedirect("/events");
//        }
        request.getRequestDispatcher("/WEB-INF/events/index.jsp").forward(request, response);
    }

}
