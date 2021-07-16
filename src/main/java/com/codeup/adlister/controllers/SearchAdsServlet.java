package com.codeup.adlister.controllers;



import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/searchAds")
public class SearchAdsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String searchForAd = request.getParameter("search");
        request.setAttribute("search", searchForAd);
        request.setAttribute("ads", DaoFactory.getAdsDao().searchForAds(searchForAd));
        boolean noAdsFound = DaoFactory.getAdsDao().searchForAds(searchForAd).isEmpty();
        String noneFound = "There were no results found for your search of ";
        String adsFound = "Here are your search results for ";

        if (noAdsFound){
            request.setAttribute("result", noneFound);
        } else {
            request.setAttribute("result", adsFound);
        }
        request.getRequestDispatcher("/WEB-INF/ads/searchResults.jsp").forward(request, response);
    }
}
