package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("confirm_password");

        if (username == null) {
            username = " ";
        }else{
            request.getSession().setAttribute("username", username);
        }

        if (email == null) {
            email = " ";
        }else{
            request.getSession().setAttribute("email", email);
        }

        // validate input
        boolean usernameError = username.isEmpty();
        boolean emailError = email.isEmpty();
        boolean passwordError = password.isEmpty();
        boolean passwordDontMatch = (! password.equals(passwordConfirmation));
//        Old function
//        boolean inputHasErrors = username.isEmpty()
//            || email.isEmpty()
//            || password.isEmpty()
//            || (! password.equals(passwordConfirmation));

        if (usernameError) {
            request.getSession().setAttribute("error","Username Error, Please Try Again");
            response.sendRedirect("/register");
            return;
        }
        if (emailError) {
            request.getSession().setAttribute("error","Email Error, Please Try Again");
            response.sendRedirect("/register");
            return;
        }
        if (passwordError) {
            request.getSession().setAttribute("error","Password Error, Please Try Again");
            response.sendRedirect("/register");
            return;
        }
        if (passwordDontMatch) {
            request.getSession().setAttribute("error","Passwords Didn't Match, Please Try Again");
            response.sendRedirect("/register");
            return;
        }

        // create and save a new user
        User user = new User(username, email, password);
        if (DaoFactory.getUsersDao().findByUsername(user.getUsername()) != null){
            request.getSession().setAttribute("error","Username Already Exists, Please Try Again");
            response.sendRedirect("/register");
            return;
        }
        if (DaoFactory.getUsersDao().findByEmail(user.getEmail()) != null){
            request.getSession().setAttribute("error","Email is Already in Use, Please Try Again");
            response.sendRedirect("/register");
            return;
        }

        DaoFactory.getUsersDao().insert(user);
        response.sendRedirect("/login");
    }

}
