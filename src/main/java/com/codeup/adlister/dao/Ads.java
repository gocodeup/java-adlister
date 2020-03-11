package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();
    // insert a new ad and return the new ad's id
    int insert(Ad ad);
    void addtoAdCategoryTable(int adId, int catId) throws SQLException;
    // get the details of a certain ad
    List<Ad> adDetails(int id);

}
