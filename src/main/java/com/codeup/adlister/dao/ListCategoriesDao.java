package com.codeup.adlister.dao;

import com.codeup.adlister.models.Category;

import java.util.ArrayList;
import java.util.List;

public class ListCategoriesDao {

    private List<Category> categories;


    public List<Category> all() {
        if (categories == null) {
            categories = generateCategories();
        }
        return categories;
    }

    private List<Category> generateCategories() {
        List<Category> categories = new ArrayList<>();
        return categories;
    }

}
