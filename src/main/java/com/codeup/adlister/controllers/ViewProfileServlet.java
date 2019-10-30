package com.codeup.adlister.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.ViewProfileServlet", urlPatterns = "/profile")
public class ViewProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< HEAD
        String user = request.getSession().getAttribute("user").toString();
=======
>>>>>>> 918c5ae8069317d9e258b0c919cba7ac4344cbb1
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");

            return;
        }
<<<<<<< HEAD
        User uID = (User) request.getSession().getAttribute("user");
//            I want what ever ad this user created to display on the user's profile.
//            need to take in any info from the "/ads" and somehow transfer to user's profile
//            now, how do i do that?!

        request.setAttribute("ads", DaoFactory.getAdsDao().findAdByUserId(uID));

        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
    }

}
=======
        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
    }
}
>>>>>>> 918c5ae8069317d9e258b0c919cba7ac4344cbb1
