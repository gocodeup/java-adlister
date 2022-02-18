package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserDeleteServlet", urlPatterns = "/user/delete")
public class UserDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User deleteUser = (User) request.getSession().getAttribute("User");
        DaoFactory.getUsersDao().deleteByID(deleteUser.getId());
        response.sendRedirect("/logout");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        User deleteUser = (User) request.getSession().getAttribute("user");
        DaoFactory.getUsersDao().deleteByID(deleteUser.getId());
    }
}
