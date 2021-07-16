package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
//        request.getRequestDispatcher("/WEB-INF/foo.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        Map<String, String> messages = new HashMap<String, String>();
//        request.setAttribute("messages", messages);

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
            response.sendRedirect("/register");
            return;
        }

//        String foo = request.getParameter("foo");
//        if (foo == null || foo.trim().isEmpty()) {
//            messages.put("foo", "Please enter foo");
//        } else if (!foo.matches("\\p{Alnum}+")) {
//            messages.put("foo", "Please enter alphanumeric characters only");
//        }
//
//        String bar = request.getParameter("bar");
//        if (bar == null || bar.trim().isEmpty()) {
//            messages.put("bar", "Please enter bar");
//        } else if (!bar.matches("\\d+")) {
//            messages.put("bar", "Please enter digits only");
//        }
//
//        // ...
//
//        if (messages.isEmpty()) {
//            messages.put("success", "Form successfully submitted!");
//        }
//
//        request.getRequestDispatcher("/WEB-INF/foo.jsp").forward(request, response);



//         create and save a new user
        User user = new User(username, email, password);
        DaoFactory.getUsersDao().insert(user);
        response.sendRedirect("/login");
    }
}
