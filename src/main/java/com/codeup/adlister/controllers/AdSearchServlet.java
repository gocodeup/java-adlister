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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "controllers.AdSearchServlet", urlPatterns = "/search")
public class AdSearchServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        request.getSession().removeAttribute("errorMessage");
        request.getRequestDispatcher("/WEB-INF/ads.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
                List<Ad> ads = new ArrayList<>();
                ArrayList<String> users = new ArrayList<>();
                ArrayList<String> categories = new ArrayList<>();


                if(request.getParameter("choice").equals("title")) {
                    ads = DaoFactory.getAdsDao().getByTitle(request.getParameter("query"));
                } else if (request.getParameter("choice").equals("category")){
                    ads = DaoFactory.getCategoriesDao().allAdsByCategory(request.getParameter("query"));
                }
                if (ads == null || ads.isEmpty() || request.getParameter(
                        "query").isEmpty()) {
                    if(request.getParameter("choice").equals("title")) {
                        request.getSession().setAttribute("errorMessage", "An ad with that title doesn't exist.");
                        response.sendRedirect("/ads");
                        return;
                    } else if (request.getParameter("choice").equals("category")){
                        request.getSession().setAttribute("errorMessage", "An ad with that category doesn't exist.");
                        response.sendRedirect("/ads");
                        return;
                    }
                } else {
                    for (long i = 0; i <= ads.size()-1; i++) {
                        users.add(DaoFactory.getUsersDao().findByUserId(ads.get((int) i).getUserId()).getUsername());
                        StringBuilder stringy = new StringBuilder();
                        for (String item : DaoFactory.getCategoriesDao().findByAdId(ads.get((int) i).getId())) {
                            if(item.length() <=0){
                                stringy.append(item);
                                continue;
                            }
                            stringy.append(item);
                            stringy.append(", ");
                        }
                        if (stringy.length() > 0) {
                            String postString = stringy.toString();
                            categories.add(postString.substring(0, postString.length()-2));
                        } else {
                            categories.add(stringy.toString());
                        }
                    }
                    request.getSession().removeAttribute("errorMessage");
                    request.setAttribute("ads", ads);
                    request.setAttribute("users", users);
                    request.getRequestDispatcher("/WEB-INF/ads/ad.jsp").forward(request, response);

                }
            }
        }
