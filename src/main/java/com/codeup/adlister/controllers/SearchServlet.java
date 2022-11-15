

package com.codeup.adlister.controllers;
import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SearchServlet", urlPatterns = "/search")
public class SearchServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String search = request.getParameter("search");
        System.out.println(search);
        // String wilSearch = "%"+search+"%";
        request.setAttribute("ads", DaoFactory.getAdsDao().searchAD(search));
        request.getRequestDispatcher("/WEB-INF/ads/searchAds.jsp").forward(request, response);
    }
}