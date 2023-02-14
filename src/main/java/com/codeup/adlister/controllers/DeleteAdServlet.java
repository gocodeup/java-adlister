package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.JSON;
import com.codeup.adlister.models.User;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "controllers.DeleteAdServlet", urlPatterns = "/ads/delete")
public class DeleteAdServlet extends HttpServlet {

    private Gson gson = new Gson();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");
        String selected = request.getQueryString();
        Ad ad = DaoFactory.getAdsDao().findById(selected);
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        String jsonString;
        if(ad.getUserId() == user.getId()){
                DaoFactory.getAdsDao().deleteAd(selected);
                JSON json = new JSON("Your Ad labeled "+ ad.getTitle() +" was deleted");
                jsonString = this.gson.toJson(json);
        }
        else{
            JSON json = new JSON("Could not delete ad");
            jsonString = this.gson.toJson(json);
        }
        out.print(jsonString);
        out.flush();
    }
}
