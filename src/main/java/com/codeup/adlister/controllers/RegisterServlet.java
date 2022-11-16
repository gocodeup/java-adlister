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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        System.out.println(password);
        String passwordConfirmation = request.getParameter("confirm_password");

        // validate input
//        boolean inputHasErrors = username.isEmpty()
//                || email.isEmpty()
//                || password.isEmpty()
//                || (!password.equals(passwordConfirmation));
//
//        if (inputHasErrors) {
//            response.sendRedirect("/register");
//            return;
//        }


        User userName = DaoFactory.getUsersDao().findByUsername(username);
        User emailTest = DaoFactory.getUsersDao().findByEmail(email);

        boolean correctInfo = false;
        if (userName != null && username.equals(userName.getUsername())) {
            request.setAttribute("usernameExists", "This username is already in use, please try another.");
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        } else if (!email.contains("@")) {
            request.setAttribute("emailError", "You need to enter a valid email address!");
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        } else if (emailTest != null && email.equals(emailTest.getEmail())) {
            request.setAttribute("emailExists", "The email you entered already exists.");
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        } else if (!password.equals(passwordConfirmation)) {
            request.setAttribute("passwordMismatch", "Please confirm your password you re-entered is correct.");
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);

        else {
                correctInfo = true;
            }
        }
    }


}










