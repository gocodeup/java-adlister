package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.AdCategory;
import com.codeup.adlister.models.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="controllers.SearchAdsServlet", urlPatterns="/Categories/category")
public class ShowAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String category = req.getParameter("category");
        String searchCategory = getCategory(category);
        req.setAttribute("category", searchCategory);

        List<AdCategory> categories = DaoFactory.getAdsDao().getAdsFromCategory(searchCategory);
        req.setAttribute("ads", category);
        req.getRequestDispatcher("/WEB-INF/ads/category.jsp").forward(req, res);
    }

    protected String getCategory(String category) {
        String actualCategory = "";
        if (category.equals("For Sale")) {
            actualCategory = "For Sale";
        } else if (category.equals("Automotive")) {
            actualCategory = "Automotive";
        } else if (category.equals("Jobs")) {
            actualCategory = "Jobs";
        } else if (category.equals("Community")) {
            actualCategory = "Community";
//        } else if (category.equals("")) {
//            actualCategory = "";
        }
        return actualCategory;
    }
}
//        @WebServlet("/ad")
//        public class ShowAdServlet extends HttpServlet {
//            protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//                long id = Long.parseLong(req.getParameter("id"));
//                try {
//                    Ad ad = DaoFactory.getAdsDao().findOne(id);
//                    req.setAttribute("ad", ad);
//                    User user = DaoFactory.getUsersDao().findById(ad.getUserId());
//                    req.setAttribute("adUser", user);
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//                req.getRequestDispatcher("/WEB-INF/ads/showAd.jsp").forward(req, res);
//            }
//
//            public static void main(String[] args) {
//
//            }
//early version ND
//        long id = Long.parseLong(req.getParameter("id"));
//        String adId = req.getParameter("id");
//        req.setAttribute("ad", adId);
//        if(adId != null){
//
//        }

//      need to get id of ad
//  here we will bring in DaoFactory here to getAdById()
//      need to set id of ad to "ad"
//      req.setAttribute("ad", id)
//        req.getRequestDispatcher("/WEB-INF/ads/search.jsp").forward(req, res);
//    }
//
//    public static void main(String[] args) {
//
// @WebServlet("/ad")
// public class ShowAdServlet extends HttpServlet {
//   protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//     long id = Long.parseLong(req.getParameter("id"));
//      try {
//         Ad ad = DaoFactory.getAdsDao().findOne(id);
//          req.setAttribute("ad", ad);
//         User user = DaoFactory.getUsersDao().findById(ad.getUserId());
//          req.setAttribute("adUser", user);
//     } catch (SQLException e) {
//         e.printStackTrace();
//     }
//      req.getRequestDispatcher("/WEB-INF/ads/showAd.jsp").forward(req, res);
//  }
//
//    public static void main(String[] args) {
//
//   }
//}
