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

@WebServlet("/ads/update")
public class UpdateAdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String idQuery = req.getParameter("id");
//        Ad ad = DaoFactory.getAdsDao().findByStringId(idQuery);
//        User user = (User) req.getSession().getAttribute("user");
//        if (ad.getUserId() != user.getId()) {
//            resp.sendRedirect("/profile");
//        } else {
//            req.getSession().setAttribute("ad", ad);
//        }


        Long id = Long.parseLong(req.getParameter("ad_id"));
        Ad ad = DaoFactory.getAdsDao().findById(id);
        req.getSession().setAttribute("ad", ad);
        req.getRequestDispatcher("/WEB-INF/ads/update.jsp").forward(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String description = req.getParameter("description");

        boolean inputHasErrors = title.isEmpty() || description.isEmpty();

        if (inputHasErrors) {
            resp.sendRedirect("/ads/update");
        }

        Ad ad = (Ad) req.getSession().getAttribute("ad");
        ad.setTitle(title);
        ad.setDescription(description);

        DaoFactory.getAdsDao().update(ad);
        if (req.getSession().getAttribute("vp") == null){
            resp.sendRedirect("/ads");
        } else {
            resp.sendRedirect("/profile");
        }

    }
}
