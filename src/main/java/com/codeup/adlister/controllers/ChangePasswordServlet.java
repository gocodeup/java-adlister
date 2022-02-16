package com.codeup.adlister.controllers;


import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;

import javax.imageio.IIOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ChangePasswordServlet", urlPatterns = "/user/password")
public class ChangePasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User editUser = (User) request.getSession().getAttribute("user");
        String newPassword = request.getParameter("newPassword");
        String hashPassword = Password.hash(newPassword);

        DaoFactory.getUsersDao().updateUserPassword(editUser.getId(),hashPassword);
        response.sendRedirect("/profile");
    }
}
