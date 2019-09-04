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
import java.util.List;

@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/ads/create")
public class CreateAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("categories", DaoFactory.getCategoriesDao().all());
        request.setAttribute("blocks", DaoFactory.getBlocksDao().all());

        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/ads/create.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        Integer blockId = (Integer) Integer.parseInt(request.getParameter("block") );
        String block = request.getParameter("block");
        int categoryId = Integer.parseInt(request.getParameter("category"));

        Ad ad = new Ad(user.getId(), title, description,  blockId);

        if (title == null) {
            title = " ";
        }else{
            request.getSession().setAttribute("title", title);
        }

        if (description == null) {
            description = " ";
        }else{
            request.getSession().setAttribute("description", description);
        }
        DaoFactory.getAdsDao().insert(ad);
        List<Ad> adsHere = DaoFactory.getAdsDao().userAds(user.getId());
        Long newId = null;

        for (Ad adHere : adsHere) {
            if (adHere.getTitle().equalsIgnoreCase(title)){
                newId = adHere.getId();
            }
        }
        System.out.println("newId = " + newId);
        System.out.println("categoryId = " + categoryId);
        DaoFactory.getAdsDao().insertCat(newId, categoryId);
        response.sendRedirect("/ads");
    }
}
