package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/ads/create")
public class CreateAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("categories", DaoFactory.getCategoriesDao().all());
        request.setAttribute("blocks", DaoFactory.getBlocksDao().all());

        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/ads/create.jsp")
            .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        Integer blockId = (Integer) Integer.parseInt(request.getParameter("block") );
        Integer categoryId = (Integer) Integer.parseInt(request.getParameter("category"));

        Ad ad = new Ad( user.getId(), title,  description,  blockId, categoryId);

        if (title == null) {
            title = " ";
        }else{
            request.getSession().setAttribute("title", title);
        }

        if (description == null) {
            description = " ";
        }else{
            request.getSession().setAttribute("description", description);
        }


        DaoFactory.getAdsDao().insert(ad);
        response.sendRedirect("/ads");
    }

//    change for commit
}
