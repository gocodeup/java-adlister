package com.codeup.adlister.controllers;


import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;

import javax.imageio.IIOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditProfileServlet", urlPatterns = "/editProfile")
public class EditProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //if user is null, will be redirected to login page
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/editProfile.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("confirmPassword");
        //set hash password
        String hash = Password.hash(password);
        String errorMessage = "";
        //created user to access id and username
        User user = (User) request.getSession().getAttribute("user");
        System.out.println(user.getId());
        System.out.println(email);
        System.out.println(password);
        System.out.println(passwordConfirmation);

        //boolean if email and password are empty or passwords don't match
        boolean inputHasErrors = email.isEmpty()
                || password.isEmpty()
                || (! password.equals(passwordConfirmation));
        //if statement with inputHasErrors boolean
        //if has any error then other if statements will add string to
        //errorMessage variable
        if(inputHasErrors){
            if(email.isEmpty()){
                errorMessage += "Please enter a valid email";
            }
            if(password.isEmpty()){
                errorMessage += "Please enter a password";
            }
            if(! password.equals(passwordConfirmation)){
                errorMessage += "Passwords do not match";
            }

            //sets errorMessage to editError
            request.getSession().setAttribute("editError", errorMessage);
            response.sendRedirect("/editProfile");
        }else{
            //create new User object called update adds User object user username and id with email and hash
            User update = new User(user.getId(), user.getUsername(), email, hash);
            DaoFactory.getUsersDao().updateUser(update);
            request.getSession().removeAttribute("user");
            request.getSession().invalidate();
            response.sendRedirect("/login");

        }


    }
}
