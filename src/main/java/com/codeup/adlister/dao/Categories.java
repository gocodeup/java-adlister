package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;

import java.util.List;

public interface Categories {
    // list all categories in the category table
    List<Category> all();

    // find all ads with a specific category
    List<Ad> findByCategory(String category);
}
