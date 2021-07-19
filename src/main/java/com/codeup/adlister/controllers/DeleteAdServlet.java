package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteAdServlet", urlPatterns = "/ads/delete")
public class DeleteAdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }


long id = Long.parseLong(request.getParameter("id"));
Ad ad = DaoFactory.getAdsDao().getAdById(id);
DaoFactory.getAdsDao().deleteAd(ad);

if (request.getSession().getAttribute("user") != null) {
    response.sendRedirect("/ads");
    return;
}

}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/");

    }
}
