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

        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/profile");
            return;
        }
        if (request.getSession().getAttribute("user") == null) {
        }
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        if (username == null) username = " ";
        String password = request.getParameter("password");
        User user = DaoFactory.getUsersDao().findByUsername(username);
        Cookie[]cookies = request.getCookies();
//        String referer = request.getHeader("Referer");

        if (user == null) {
            request.getSession().setAttribute("error", "Invalid Username or Password");
            return;
        }

        boolean validAttempt = Password.check(password, user.getPassword());

        if (validAttempt) {
            request.getSession().setAttribute("user", user);
            response.sendRedirect("/profile");
                return;
//        } if (validAttempt && cookies != null) {
//            request.getSession().setAttribute("user", user);
//            response.sendRedirect(referer);
//            for (Cookie cookie : cookies) {
//                cookie.setValue("");
//                cookie.setMaxAge(0);
//            }
//                return;
        } else {
            response.sendRedirect("/login");
        }
    }
}
