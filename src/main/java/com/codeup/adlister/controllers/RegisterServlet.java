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
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("confirm_password");
        String errorMessage = "";


        // validate input
        boolean inputHasErrors = username.isEmpty()
            || email.isEmpty()
            || password.isEmpty()
            || (! password.equals(passwordConfirmation));

        //added if statements under inputHasErrors
        if (inputHasErrors) {
            // if user is missing a field then a string message is added to the var errorMessage
            //and continues to the next if statement
            if(username.isEmpty()){
                errorMessage += "Username is required for registration<br> ";

            }
            if(email.isEmpty()){
                errorMessage += "Email is required for registration<br> ";
            }
            if (password.isEmpty()){
                errorMessage += "Password is required for registration <br>";
            }
            if(! password.equals(passwordConfirmation)){
                errorMessage += "Passwords do not match";
            }
            //var errorMessage is set to attribute error
            request.getSession().setAttribute("error", errorMessage);
            response.sendRedirect("/register");

            //username variable is input to findByUsername, if it is not null
            //errorMessage will be assigned new string and will redirect to register
        } else if(DaoFactory.getUsersDao().findByUsername(username) != null){
            errorMessage = "Username already exists";

            //var errorMessage is set to attribute error
            request.getSession().setAttribute("error", errorMessage);
            response.sendRedirect("/register");

            //email variable is input to findByUserEmail, if it is not null
            //errorMessage will be assigned new string and will redirect to register
        }else if(DaoFactory.getUsersDao().findByUserEmail(email) != null){
            errorMessage = "Email is already used";

            //var errorMessage is set to attribute error
            request.getSession().setAttribute("error", errorMessage);
            response.sendRedirect("/register");

        }else{
            // create and save a new user
            User user = new User(username, email, password);
            DaoFactory.getUsersDao().insert(user);
            response.sendRedirect("/login");

        }




    }
}
