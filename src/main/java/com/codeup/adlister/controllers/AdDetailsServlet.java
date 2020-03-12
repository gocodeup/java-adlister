package com.codeup.adlister.controllers;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "controllers.AdDetailsServlet", urlPatterns = "/adDetails")
public class AdDetailsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setAttribute("ads", DaoFactory.getAdsDao().adDetails(1));
        request.getRequestDispatcher("/WEB-INF/ads/adDetails.jsp").forward(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int adId = Integer.parseInt(request.getParameter("button"));
        request.setAttribute("ads", DaoFactory.getAdsDao().adDetails(adId));
        User user = DaoFactory.getUsersDao().findByAdId(adId);
        request.setAttribute("user", user);
        request.getRequestDispatcher("/WEB-INF/ads/adDetails.jsp").forward(request, response);
    }
}