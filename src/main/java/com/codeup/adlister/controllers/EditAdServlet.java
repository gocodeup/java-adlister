package com.codeup.adlister.controllers;


import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.AdCat;
import com.codeup.adlister.models.ReturnedCats;
import com.codeup.adlister.models.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@WebServlet(name = "controllers.EditAdServlet", urlPatterns = "/ads/edit")
public class EditAdServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        String selected = request.getQueryString();
        System.out.println(selected);
        if(user == null){
            response.sendRedirect("/login?"+selected);
        }
        else{
            Ad returned = DaoFactory.getAdsDao().findById(selected);
            User owner = DaoFactory.getUsersDao().findById(String.valueOf(returned.getUserId()));
            if(owner.getId() == user.getId()){

                List<AdCat> returnedCats = DaoFactory.getAdCatsDao().getRelatedAdCat(selected);
                request.setAttribute("checked", returnedCats);
                request.setAttribute("ad", returned);
                request.setAttribute("user", user);
                request.setAttribute("categories", DaoFactory.getCategoryDao().all());
                request.getRequestDispatcher("/WEB-INF/ads/editAd.jsp").forward(request, response);
            }

        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        String adId = request.getParameter("id");
        String adTitle = request.getParameter("title");
        String description = request.getParameter("description");
        if(user == null){
            response.sendRedirect("/login?");
        }
        else{
            Ad returned = DaoFactory.getAdsDao().findById(adId);
            User owner = DaoFactory.getUsersDao().findById(String.valueOf(returned.getUserId()));
            if(owner.getId() == user.getId()){
                String result = DaoFactory.getAdsDao().updateAd(adId,adTitle,description);
                if(Objects.equals(result, "updated")){
                    DaoFactory.getAdCatsDao().deleteAdCat(adId);
                    String[] recievedCats = request.getParameterValues("category");
                    if(recievedCats != null){
                        for (String cat : recievedCats) {
                            AdCat adCat = new AdCat((int) returned.getId(), Integer.parseInt(cat));
                            DaoFactory.getAdCatsDao().insert(adCat);
                        }
                    }
                    response.sendRedirect("/ads/ad?"+adId);
                }
                else{
                    response.sendRedirect("/ads");
                }
            }
            else{
                response.sendRedirect("/ads");
            }

        }

    }
}

