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
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/profile");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("confirm_password");

        boolean inputHasErrors =
                username.isEmpty()
                        || email.isEmpty()
                        || !email.contains("@")
                        || password.isEmpty()
                        || (!password.equals(passwordConfirmation));

        if (inputHasErrors) {
            response.sendRedirect("/register");
            return;
        }
        System.out.println("this is somewhat working");

        boolean usernameNotExist = false;
        boolean emailNotExist = false;
        boolean userConflicts = false;

        User nameTest = DaoFactory.getUsersDao().findByUsername(username);
        User emailTest = DaoFactory.getUsersDao().findByEmail(email);

        if (nameTest == null) {
            usernameNotExist = true;
        }
        if (emailTest == null) {
            emailNotExist = true;
        }
        if (usernameNotExist && emailNotExist) {
            userConflicts = true;
        }

        String usernameExistMessage = "<script>alert('The Username already exists, try again');</script>";
        String emailExistMessage = "<script>alert('The email already exist with another user, try again');</script>";
        String emaiNUsernameExistMessage = "<script>alert('The username and email already exist with another user, try again');</script>";

        if (userConflicts) {
            User user = new User(username, email, password);
            DaoFactory.getUsersDao().insert(user);
            response.sendRedirect("/login");
        } else if (!usernameNotExist && !emailNotExist) {
            request.setAttribute("emaiNUsernameExistMessage", emaiNUsernameExistMessage);
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        } else if (!emailNotExist) {
            request.setAttribute("username", username);
            request.setAttribute("emailExistMessage", emailExistMessage);
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        } else {
            request.setAttribute("email", email);
            request.setAttribute("usernameExistMessage", usernameExistMessage);
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
    }
}