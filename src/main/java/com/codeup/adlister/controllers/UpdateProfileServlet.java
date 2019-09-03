package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.UpdateProfileServlet", urlPatterns = "/update")
public class UpdateProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie message = new Cookie("message", "Welcome to the profile page");

        if (request.getSession().getAttribute("user") == null) {
            response.addCookie(message);
            response.sendRedirect("/login");
            return;
        }
        User sessionUser = (User) request.getSession().getAttribute("user");
        request.setAttribute("ads", DaoFactory.getAdsDao().userAds((sessionUser.getId())));
        request.getRequestDispatcher("/WEB-INF/update_profile.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User sessionUser = (User) request.getSession().getAttribute("user");
        String oldUsername = request.getParameter("oldUsername");
        String oldEmail = request.getParameter("oldEmail");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        String newPasswordConfirmation = request.getParameter("confirm_password");

//        if (username == null) {
//            username = " ";
//        } else {
//            request.getSession().setAttribute("username", username);
//        }
//
//        if (email == null) {
//            email = " ";
//        } else {
//            request.getSession().setAttribute("email", email);
//        }
//
        // validate input
        boolean usernameError = username.isEmpty();
        boolean emailError = email.isEmpty();
        boolean oldPasswordError = oldPassword.isEmpty();
        boolean newPasswordError = newPassword.isEmpty();
        boolean newPasswordConfirmationError = (!newPassword.equals(newPasswordConfirmation));

        if (usernameError) {
            request.getSession().setAttribute("error", "Username Error, Please Try Again");
            response.sendRedirect("/update");
            return;
        }
        if (emailError) {
            request.getSession().setAttribute("error", "Email Error, Please Try Again");
            response.sendRedirect("/update");
            return;
        }
        if (oldPasswordError) {
            request.getSession().setAttribute("error", "Password Error, Please Try Again");
            response.sendRedirect("/update");
            return;
        }
        if (newPasswordError) {
            request.getSession().setAttribute("error", "New Password Error, Please Try Again");
            response.sendRedirect("/update");
            return;
        }
        if (newPasswordConfirmationError) {
            request.getSession().setAttribute("error", "New Passwords Didn't Match, Please Try Again");
            response.sendRedirect("/update");
            return;
        }

        // create new user, delete old
//            String name = sessionUser.getUsername();
//
//            DaoFactory.getUsersDao().updateUserInfo(oldUsername);

//        DaoFactory.getUsersDao().deleteUserByUsername(oldEmail);
            User user = new User(sessionUser.getId(), username, email, BCrypt.hashpw(newPassword, BCrypt.gensalt()));

//            if (! DaoFactory.getUsersDao().findByUsername(username).getUsername().equalsIgnoreCase(oldUsername)) {
//                request.getSession().setAttribute("error", "Username Already Exists, Please Try Again");
//                DaoFactory.getUsersDao().insert(sessionUser);
//                response.sendRedirect("/update");
//                return;
//            }
//            if (! DaoFactory.getUsersDao().findByUsername(username).getEmail().equalsIgnoreCase(oldEmail)) {
//                request.getSession().setAttribute("error", "Email is Already in Use, Please Try Again");
//                DaoFactory.getUsersDao().insert(sessionUser);
//                response.sendRedirect("/update");
//                return;
//            }


            request.getSession().setAttribute("user", user);


            DaoFactory.getUsersDao().updateUserInfo(user);

            response.sendRedirect("/profile");
    }

}

//FIX UPDATE