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

@WebServlet(name = "ChangeEmailServlet", urlPatterns = "/user/email")
public class ChangeEmailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User editUser = (User) request.getSession().getAttribute("User");
        String newEmail = request.getParameter("newEmail");
       // String newPassword = null;
        //String hashPower = Password.hash(newPassword);

//        DaoFactory.getUsersDao().updateUserEmail(editUser.getId(), newEmail);
        response.sendRedirect("/profile");

    }
}
