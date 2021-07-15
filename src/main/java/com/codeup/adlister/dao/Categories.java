package com.codeup.adlister.dao;

import com.codeup.adlister.models.Category;

import java.util.List;

public interface Categories {
    // get a list of all the cateogires
    List<Category> all();
    // insert a new category and return the new category's id
    Long insert(Category category);
    List<Category> allCategoriesForAd(long adId);
    void deleteCategory(Long categoryId);

    Category showCategory(long id);
}
