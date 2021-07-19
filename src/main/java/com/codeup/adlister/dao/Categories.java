package com.codeup.adlister.dao;


import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;

import java.sql.SQLException;
import java.util.List;

public interface Categories {
    Category getCategoryById(long id);
    List <Category> getAllCategories();
long insertAdCategories(Category category) throws SQLException;
List<String> printCategories(long ad_id);
List<String> printCategories();


}
