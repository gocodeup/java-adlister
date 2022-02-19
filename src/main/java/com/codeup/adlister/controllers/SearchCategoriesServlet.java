package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.Categories;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "controllers.SearchCategoriesServlet", urlPatterns = "/ads/categories")
public class SearchCategoriesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String category = request.getParameter("category"); //gets category
        String searchCategory = getCategory(category);
        request.setAttribute("category", searchCategory);



        List<Ad> ads = DaoFactory.getAdsDao().getAdByCategory(category); //gets all ads with category


        request.setAttribute("ads", categories); //sets ad attribute
        request.getRequestDispatcher("/WEB-INF/ads/categories.jsp").forward(request, response);
    }
    protected String getCategory(String category){
        String actualCategory = "";
        if(category.equals("Automobile")){
            actualCategory = "Automobile";
        }
        else if(category.equals("Clothing")){
            actualCategory = "Clothing";
        }
        else if(category.equals("Electronics")){
            actualCategory = "Electronics";
        }
        else if(category.equals("Furniture")){
            actualCategory = "Furniture";
        }
        else if(category.equals("Miscellaneous")){
            actualCategory = "Miscellaneous";
        }
        else if(category.equals("Home")){
            actualCategory = "Home";
        }
        else if(category.equals("Tools")){
            actualCategory = "Tools";
        }
        else if(category.equals("Toys")){
            actualCategory = "Toys";
        }
        return actualCategory;
    }

//    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    String keyword2 = request.getParameter("keyword2");
//
//        if (keyword2.isEmpty()){
//        response.sendRedirect("/ads");
//        return;
//    }
//
//    List<Category> categories = DaoFactory.getCategoriesDao().search(keyword2);
//        request.setAttribute("ads", categories);
//  System.out.println(categories);
//        request.getRequestDispatcher("/WEB-INF/ads/categories.jsp").forward(request,response);
//
//}

}
