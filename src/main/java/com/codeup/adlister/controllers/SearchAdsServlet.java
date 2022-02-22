package com.codeup.adlister.controllers;


import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name="controllers.SearchAdsServlet", urlPatterns="/searchAds")
public class SearchAdsServlet extends HttpServlet {
//    public void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws IOException{
//
//    }
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    String keyword = request.getParameter("keyword");
    if(keyword.isEmpty()) {
        response.sendRedirect("/ads");
        return;
    }
            try{
    List<Ad> keywordAds = DaoFactory.getAdsDao().findAdByKeyword(keyword);
    request.setAttribute("ads", keywordAds);
    request.getRequestDispatcher("/WEB-INF/ads/keywordAds.jsp").forward(request, response);
            if (keywordAds.size() == 0) {
                request.setAttribute("zeroResults", true);
            } else {
                request.setAttribute("zeroResults", false);
            }
            request.setAttribute("keyword", keyword.toLowerCase());
            request.setAttribute("ads", keywordAds);
            request.getRequestDispatcher("/WEB-INF/ads/showAd.jsp").forward(request, response);
            for (Ad ad : keywordAds) {
                System.out.println(ad.getTitle());
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
