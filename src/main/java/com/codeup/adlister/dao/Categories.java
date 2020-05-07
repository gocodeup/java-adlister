package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;

import java.util.List;

public interface Categories {
    List<Category> all();

    Long insert(int id, int categoryId);

    List<Category> combined(Ad ad);

    int deleteCategoriesPerAd(int id);
}
