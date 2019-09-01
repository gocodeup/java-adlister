package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        if (request.getSession().getAttribute("user") != null) {
//            response.sendRedirect("/profile");
//            return;
//        }
//        if (request.getSession().getAttribute("user") == null) {
//        }
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
//        String lurker = request.getParameter("from");
        User user = DaoFactory.getUsersDao().findByUsername(username);
        Cookie[] cookies = request.getCookies();
        String lurker = request.getParameter("from").replace("/WEB-INF", "").replace("/index", "").replace(".jsp", "");

        if (username == null) {
            username = "";
        } else {
            request.getSession().setAttribute("username", username);
        }

        if (user == null) {
            request.getSession().setAttribute("error", "Invalid Username or Password");
            return;
        }

        boolean validAttempt = Password.check(password, user.getPassword());

        if (validAttempt) {
            request.getSession().setAttribute("user", user);

            if (lurker != null && lurker == "") {
                response.sendRedirect("/profile");
                return;
            }
            if (lurker != null) {
                response.sendRedirect(lurker);
                return;
            }
            if (lurker == null) {
                response.sendRedirect("/profile");
                return;
            }
            else {
                response.sendRedirect("/login");
            }
        }
    }
}
