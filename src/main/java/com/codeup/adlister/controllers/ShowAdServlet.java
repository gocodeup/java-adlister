package com.codeup.adlister.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ad/id")
public class ShowAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
//      need to get id of ad
        //  here we will bring in DaoFactory here to getAdById()
//      need to set id of ad to "ad"
//      req.setAttribute("ad", id)
        req.getRequestDispatcher("/WEB-INF/ads/showAd.jsp").forward(req, res);
    }

    public static void main(String[] args) {

    }
}
