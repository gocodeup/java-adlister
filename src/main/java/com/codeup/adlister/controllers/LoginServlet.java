package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.JSON;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
        String selected = request.getQueryString();
        if(selected != null){
            request.setAttribute("redirect", selected);
        }
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = DaoFactory.getUsersDao().findByUsername(username);

        if (user == null) {
            response.sendRedirect("/login");
            return;
        }
        boolean validAttempt = Password.check(password, user.getPassword());
        String selected = request.getParameter("redirect");

        if (validAttempt) {
            if(selected != null){
                request.getSession().setAttribute("user", user);
                response.sendRedirect("/ads/ad?"+selected);
            }
            else{
                request.getSession().setAttribute("user", user);
                response.sendRedirect("/profile");
            }

        } else {
            request.setAttribute("error", new JSON("Username and/or password does not match"));
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }
}
