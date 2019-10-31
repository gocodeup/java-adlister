package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.util.List;

public interface Categories {

    List<String> getCategoriesById(long id);

    void insert(Ad ad);

    long getCategory(String category);


}
