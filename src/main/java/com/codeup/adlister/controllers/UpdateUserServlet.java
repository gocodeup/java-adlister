package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import com.mysql.cj.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "controllers.UpdateUserServlet", urlPatterns = "/updateUser")
public class UpdateUserServlet extends HttpServlet {

String userName1;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        userName1 = (String)session.getAttribute("user");

        request.getRequestDispatcher("/WEB-INF/updateUser.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("confirm_password");

        // validate input
        boolean inputHasErrors = username.isEmpty()
                || email.isEmpty()
                || password.isEmpty()
                || (! password.equals(passwordConfirmation));

        if (inputHasErrors) {
            response.sendRedirect("/updateUser.jsp");
            return;
        }

        // create and save a new user
        User user = new User(username, email, password);
    User u =    DaoFactory.getUsersDao().findByUsername(userName1);
        DaoFactory.getUsersDao().update(u,username,email,password);
        response.sendRedirect("/login");
    }
}
