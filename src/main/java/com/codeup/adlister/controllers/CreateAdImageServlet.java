package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.AdImage;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ads/images")
public class CreateAdImageServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        // user made request for /ads/images?adid=7
        long adId = Long.parseLong(request.getParameter("adid"));
        request.setAttribute("adid", adId);
        request.getRequestDispatcher("/WEB-INF/ads/adImage.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");
        long adid = Long.parseLong(request.getParameter("adid"));
        AdImage adImg = new AdImage(
                adid,
                request.getParameter("path")
        );
        DaoFactory.getAdImagesDao().insert(adImg);
        response.sendRedirect("/ads");
    }
}
