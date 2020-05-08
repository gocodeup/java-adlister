package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.mysql.cj.mysqlx.protobuf.MysqlxDatatypes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "controllers.AdsIndexServlet", urlPatterns = "/ads")
public class AdsIndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<String> users = new ArrayList<>();
        ArrayList<String> categories = new ArrayList<>();
        List<Ad> adShrink = DaoFactory.getAdsDao().all();
        for (long i = 0; i <= adShrink.size()-1; i++) {
            users.add(DaoFactory.getUsersDao().findByUserId(adShrink.get((int) i).getUserId()).getUsername());
            StringBuilder stringy = new StringBuilder();
            for (String item : DaoFactory.getCategoriesDao().findByAdId(adShrink.get((int) i).getId())) {
                if(item.length() <=0){
                    stringy.append(item);
                    continue;
                }
                stringy.append(item);
                stringy.append(", ");
            }
            if (stringy.length() > 0) {
                String postString = stringy.toString();
                categories.add(postString.substring(0, postString.length()-2));
            } else {
                categories.add(stringy.toString());
            }
        }
            request.setAttribute("ads", adShrink);
            request.setAttribute("users", users);
            request.setAttribute("categories", categories);
            request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);

    }
}
