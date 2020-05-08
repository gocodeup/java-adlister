package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;

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
        String errorMessage = "";
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("confirm_password");

        // validate input
        boolean inputHasErrors = username.isEmpty()
            || email.isEmpty()
            || password.isEmpty();

        if (inputHasErrors) {
            errorMessage = "- All fields must be completed! -<br>";
        }

        if(DaoFactory.getUsersDao().findByUsername(username) != null){
            errorMessage = errorMessage + "- Username already exists, please choose another one. -<br>";
        }

        if(DaoFactory.getUsersDao().findByEmail(email) != null){
            errorMessage = errorMessage + "- Email already in use, please try another one. -<br>";
        }

        if(! password.equals(passwordConfirmation)){
            errorMessage = errorMessage + "- Passwords don't match, please try again. -<br>";
        }

        if(!errorMessage.equals("")){
            request.getSession().setAttribute("errorMessage", errorMessage.trim());
            response.sendRedirect("/register");
            return;
        }


            request.getSession().removeAttribute("errorMessage");
            // create and save a new user
            User user = new User(username, email, password);
            DaoFactory.getUsersDao().insert(user);
            response.sendRedirect("/login");
        }
    }

