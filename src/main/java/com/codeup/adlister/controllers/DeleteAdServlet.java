//package com.codeup.adlister.controllers;
//
//import com.codeup.adlister.dao.DaoFactory;
//import com.codeup.adlister.dao.MySQLAdsDao;
//import com.codeup.adlister.models.User;
//import com.codeup.adlister.controllers.UpdatePasswordServlet;
//
//import javax.servlet.http.HttpServlet;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//
//@WebServlet("/ad/delete")
//public class DeleteAdServlet extends HttpServlet {
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.getSession().setAttribute("url", "/update");
//        if (request.getSession().getAttribute("user") == null) {
//            response.sendRedirect("/login");
//            return;
//        }
//        request.getRequestDispatcher("/WEB-INF/update.jsp").forward(request, response);
//    }
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
//        User user = (User) request.getSession().getAttribute("user");
//
//        String password = request.getParameter("password");
//        String passwordConfirmation = request.getParameter("confirm_password");
//
//        boolean inputHasErrors = password.isEmpty() || (! password.equals(passwordConfirmation));
//
//        if (inputHasErrors) {
//            request.setAttribute("message", "The password did not match");
//            response.sendRedirect("/update");
//            return;
//        }
//
//        user.setPassword(password);
//        DaoFactory.getUsersDao().updatePassword(user);
//        request.setAttribute("confirmation", "Your password was updated successfully.");
//        response.sendRedirect("/profile");
//
////        String adid = (String) request.getSession().getAttribute("delAdId");
////        int deladID = Integer.parseInt(adid);
////
////        int allCat = DaoFactory.getCategoriesDao().deleteCategoriesPerAd(deladID);
////
////        DaoFactory.getAdsDao().deleteAd(deladID);
////
////        response.sendRedirect("/profile");
//    }
//}
