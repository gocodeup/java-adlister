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

@WebServlet(name = "controllers.DeleteAdsServlet", urlPatterns = "/deleteAd")
public class DeleteAdsServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

            long id = Long.parseLong( request.getParameter("id"));
            System.out.println(id);

            Ad ad = DaoFactory.getAdsDao().ById(id);  //FIND THE AD TO DELETE
            DaoFactory.getAdsDao().delete(ad); // DELETE AD
            response.sendRedirect("/ads");


    }
}
