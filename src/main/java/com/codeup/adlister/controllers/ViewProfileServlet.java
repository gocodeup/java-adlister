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

@WebServlet(name = "controllers.ViewProfileServlet", urlPatterns = "/profile")
public class ViewProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        User user = (User) request.getSession().getAttribute("user");
        int userId = (int) user.getId();
        user = DaoFactory.getUsersDao().findByUserId(userId);
        request.setAttribute("categories", DaoFactory.getCategoriesDao().all()); // Make categoriesDao
        request.setAttribute("users", user);
        request.setAttribute("generalError", request.getParameter("generalError"));
        request.setAttribute("usernameError", request.getParameter("usernameError"));
        request.setAttribute("passwordError", request.getParameter("passwordError"));
        request.setAttribute("emailError", request.getParameter("emailError"));

        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String edit = request.getParameter("editSend");
        String delete = request.getParameter("deleteSend");
        String update = request.getParameter("updateId");
        String username = "";
        String password = "";
        String email = "";
        Boolean validate = false;

        if (edit != null) {
            request.getSession().setAttribute("username", edit);
            request.getSession().setAttribute("password", edit);
            request.getSession().setAttribute("email", edit);
            response.sendRedirect("/update");
        }

        if (delete != null) {
            request.getSession().setAttribute("username", delete);
            request.getSession().setAttribute("password", delete);
            request.getSession().setAttribute("email", delete);
            response.sendRedirect("/update");
        }

        if (update != null) {
            username = request.getParameter("username");
            email = request.getParameter("email");
            validate = !username.equals(" ") && !email.equals(" ");
        }

        if (username != null && password != null && email != null) {
            if (validate) {
                User user = (User) request.getSession().getAttribute("username");
                Boolean checkUsername = DaoFactory.getUsersDao().findByUsername(username) == null || DaoFactory.getUsersDao().findByUsername(username).getId() == user.getId();
                Boolean checkPassword = DaoFactory.getUsersDao().findByPassword(password) == null || DaoFactory.getUsersDao().findByPassword(password).getPassword().equals(user.getPassword());
                Boolean checkEmail = DaoFactory.getUsersDao().findByEmail(email) == null || DaoFactory.getUsersDao().findByEmail(email).getEmail().equals(user.getEmail());
                Boolean checkEmailForm = Password.checkEmail(email);

                if (checkEmailForm && checkEmail && checkUsername) {
                    user.setUsername(username);
                    user.setPassword(password);
                    user.setEmail(email);
                    DaoFactory.getUsersDao().updateUser(user);
                    request.getSession().setAttribute("user", user);
                } else {
                    if (!checkEmail) {
                        request.setAttribute("emailError", "Email address is already registered. Try another.");
                    }
                    if (!checkEmailForm) {
                        request.setAttribute("emailError", "Email is not formatted correctly.");
                    }
                    if (!checkUsername) {
                        request.setAttribute("usernameError", "Username is already taken. Try another.");
                    }
                    if (!checkPassword) {
                        request.setAttribute("passwordError", "Password does not meet criteria. Try another."); // Add to ensure password adheres to criteria
                    }
                }
            } else {
                request.setAttribute("generalError", "Do not leave any fields blank.");
            }
        } else {
            request.setAttribute("generalError", "Do not leave any fields blank.");
        }
        response.sendRedirect("/profile");

        // validate input
//        boolean inputHasErrors = username.isEmpty()
//                || email.isEmpty()
//                || password.isEmpty();

//        if (inputHasErrors) {
//            response.sendRedirect("/register");
//            return;
//        }
//
//        if (DaoFactory.getUsersDao().findByUsername(username) != null) {
//            request.getSession().setAttribute("errorMessage", "Username already exists, please choose another one!");
//            response.sendRedirect("/register");
//        } else {
//            request.getSession().removeAttribute("errorMessage");

            // create and save a new user
//            User user = new User(username, email, password);
//            DaoFactory.getUsersDao().insert(user);
//            response.sendRedirect("/login");
        }
    }


