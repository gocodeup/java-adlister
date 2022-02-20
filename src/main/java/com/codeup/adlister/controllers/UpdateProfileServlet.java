package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/profile/update")
public class UpdateProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") == null) {
            resp.sendRedirect("/login");
            return;
        }
        req.getRequestDispatcher("/WEB-INF/profile/update.jsp").forward(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String email = req.getParameter("email");

        boolean inputHasErrors = username.isEmpty() || email.isEmpty();

        if (inputHasErrors) {
            resp.sendRedirect("/profile/update");
            return;
        }

        User user = (User) req.getSession().getAttribute("user");

        user.setUsername(username);
        user.setEmail(email);

        DaoFactory.getUsersDao().update(user);
        req.getSession().setAttribute("user", user);
        resp.sendRedirect("/profile");

    }
}
