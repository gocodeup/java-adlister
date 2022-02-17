package com.codeup.adlister.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/pickad")
public class PickAdServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/profile/profile.jsp").forward(req, res);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String selectAd = req.getParameter("id");
        System.out.println(selectAd);
        String getAdId = (String) req.getSession().getAttribute("id");
        System.out.println(getAdId);

        res.sendRedirect("/ad?id=" + selectAd);
    }
}


//@WebServlet(name="PickColorServlet", urlPatterns = "/pickcolor")
//public class PickColorServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        req.getRequestDispatcher("/pick-color.jsp").forward(req, res);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
//        String favColor = req.getParameter("color");
//        System.out.println(favColor);
//
//        //  to pass data, send through query
//        res.sendRedirect("/viewcolor?color=" + favColor);
//    }
//}