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
import java.sql.SQLException;

@WebServlet(name = "controllers.UpdateServlet", urlPatterns = "/update")
public class UpdateServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
//        String adId = (String) request.getSession().getAttribute("adId");
//        int id = Integer.parseInt(adId);
//        Ad updateAd = DaoFactory.getAdsDao().getById(id);
//        request.setAttribute("adName", updateAd.getTitle());
//        request.setAttribute("adDescription", updateAd.getDescription());
//        request.setAttribute("adId", id);
//        request.setAttribute("categories", DaoFactory.getCategoriesDao().all());
//        request.setAttribute("adCategories", DaoFactory.getCategoriesDao().combined(updateAd));
//        request.getRequestDispatcher("/WEB-INF/update.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int id = Integer.parseInt(request.getParameter("updateAd"));
        User user = (User) request.getSession().getAttribute("user");
        int userId = (int) user.getId();
        String name = request.getParameter("adName");
        String description = request.getParameter("adDescription");

//        if (name != null && description != null) {
//            if (!name.equals(" ") && !description.equals(" ")) {
//                Ad update = new Ad(id, userId, name, description);
//                int ok = DaoFactory.getAdsDao().updateAd(update);
//                String[] selectedCategories = request.getParameterValues("allCategories");
//
//                if (ok > 0) {
//                    DaoFactory.getCategoriesDao().deleteCategoriesPerAd((int) update.getId());
//                    if (selectedCategories != null && selectedCategories.length != 0) {
//                        for (int x = 0; x < selectedCategories.length; x++) {
//                            DaoFactory.getCategoriesDao().insert(Integer.parseInt(selectedCategories[x]), (int) update.getId());
//                        }
//                    }
//                    request.getSession().removeAttribute("adId");
                    response.sendRedirect("/profile");
                }
//            } else {
//                if (name.equals(" ")) {
//                    request.setAttribute("nameError", "Name cannot be blank");
//                } else {
//                    request.setAttribute("aName", request.getParameter("adName"));
//                }
//                request.getRequestDispatcher("/WEB-INF/update.jsp").forward(request, response);
//            }
        }
//    }
//}

//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        String email = request.getParameter("email");
//        // validate input
//
////        boolean inputHasErrors = ;
//        if (username.isEmpty()
//                || password.isEmpty()
//                || email.isEmpty()){
//        response.sendRedirect("/update");}
//
//        if (DaoFactory.getUsersDao().findByUsername(username) != null) {
//            request.getSession().setAttribute("errorMessage", "Username already exists, please choose another one!");
//            response.sendRedirect("/update");
//        } else {
//            request.getSession().removeAttribute("errorMessage");
//
//            response.sendRedirect("/update");
//        }
//    }
//}