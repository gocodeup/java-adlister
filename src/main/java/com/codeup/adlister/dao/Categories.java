package com.codeup.adlister.dao;

import com.codeup.adlister.models.Category;

import java.util.List;

public interface Categories {
    //list of all categories
    List<Category> all();

    //Show category object by title
    Category getCategoryByCatName(String category);


    Long insert(List<Category> categoryObjects);
}
