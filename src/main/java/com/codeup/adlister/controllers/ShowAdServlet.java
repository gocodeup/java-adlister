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
        Long id = Long.valueOf(req.getParameter("id"));
        req.setAttribute("ad", id);
        req.getRequestDispatcher("/WEB-INF/ads/showAd.jsp").forward(req, res);
    }

    public static void main(String[] args) {

    }
}
