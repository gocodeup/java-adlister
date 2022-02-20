package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;

import java.util.List;

public interface Categories {
    //  get all categories
    List<Category> all();
    //  insert a new Category
    Long insert(Category category);

//    ND
//    made these just in case
    void addCategory(Long ad_id, Long category_id);
    void removeCategories(Long ad_id);
    List<Ad> getAdsFromCategory(String category);
}
