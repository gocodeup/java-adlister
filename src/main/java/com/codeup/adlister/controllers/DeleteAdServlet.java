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

@WebServlet("/ads/delete")
public class DeleteAdServlet extends HttpServlet {
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
        req.getRequestDispatcher("/WEB-INF/ads/delete.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("ad_id"));
        Ad ad = DaoFactory.getAdsDao().findById(id);
        DaoFactory.getAdsDao().delete(ad);
        if (req.getSession().getAttribute("vp") == null){
            resp.sendRedirect("/ads");
        } else {
            resp.sendRedirect("/profile");
        }
    }
}
