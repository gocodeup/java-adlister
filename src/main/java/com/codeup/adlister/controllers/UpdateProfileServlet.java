package com.codeup.adlister.controllers;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;
import org.w3c.dom.ls.LSOutput;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@WebServlet(name = "controllers.UpdateProfileServlet", urlPatterns = "/updateprofile")
public class UpdateProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
//        Long id = Long.parseLong(request.getParameter("id"));
        User user = (User) request.getSession().getAttribute("user");
        request.setAttribute("user", DaoFactory.getUsersDao().findByUsername(user.getUsername()));
        request.getRequestDispatcher("/WEB-INF/updateprofile.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User currentUser = (User) request.getSession().getAttribute("user");
        try {
            if(!request.getParameter("password").equals("")) {
                User user = new User(
                        currentUser.getId(),
                        request.getParameter("username"),
                        request.getParameter("email"),
                        Password.hash(request.getParameter("password"))
                );

                DaoFactory.getUsersDao().updatePassword(user);
                request.getSession().setAttribute("user", user);
            } else {
                User user = new User(
                        currentUser.getId(),
                        request.getParameter("username"),
                        request.getParameter("email")
                );

                DaoFactory.getUsersDao().update(user);
                request.getSession().setAttribute("user", user);
            }
            response.sendRedirect("/profile");
        } catch (NumberFormatException e) {
            response.sendRedirect("/");
        }
    }
}