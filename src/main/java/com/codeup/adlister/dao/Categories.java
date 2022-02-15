package com.codeup.adlister.dao;

import com.codeup.adlister.models.Category;

import java.util.List;

public interface Categories {
    //  get all categories
    List<Category> all();
    //  insert a new Category
    Long insert(Category category);
}
