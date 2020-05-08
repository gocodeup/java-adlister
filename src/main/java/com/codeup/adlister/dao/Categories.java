package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;
import com.mysql.cj.api.mysqla.result.Resultset;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public interface Categories {
    List<Category> all();

    int insert(int id, int categoryId);

    List<Category> combined(Ad ad);

    int deleteCategoriesPerAd(int id);

    List<Ad> allAdsByCategory(String category);

    ArrayList<String> findByAdId(long id);

    ArrayList<String> createCategoriesFromResults(ResultSet rs);
}