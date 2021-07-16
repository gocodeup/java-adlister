package com.codeup.adlister.controllers;
import com.codeup.adlister.dao.DaoFactory;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DeleteAdServlet", urlPatterns = "/ads/delete")

public class DeleteAdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("user") == null){
            response.sendRedirect("/login");
            return;
        }
        Long id = Long.parseLong(request.getParameter("id"));
        PrintWriter out = response.getWriter();

//        out.println("<script>");
//        out.println("var userConfirm = Confirm('Are you sure you want to delete this ad?');" +
//                "if (userConfirm {" +
//                "        DaoFactory.getAdsDao().deleteAd(id);\n)");
//        out.println("window.location.replace('" + "/login" + "');");
//        out.println("</script>");

        DaoFactory.getAdsDao().deleteAd(id);
        response.sendRedirect("/profile");

    }
}

