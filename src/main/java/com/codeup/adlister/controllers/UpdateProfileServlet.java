package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/profile/update")
public class UpdateProfileServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, SecurityException, ServletException {
        Long id = Long.parseLong(request.getParameter("id"));

        Ad newAd = DaoFactory.getAdsDao().findByID(id);

        request.setAttribute("adToEdit", newAd);

        request.getRequestDispatcher("/WEB-INF/update.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, SecurityException, ServletException {
        Long id = Long.valueOf(request.getParameter("id"));
        String title = request.getParameter("title");
        String description = request.getParameter("description");

        DaoFactory.getAdsDao().updateAd(id, title, description);

        response.sendRedirect("/profile");
    }
}
