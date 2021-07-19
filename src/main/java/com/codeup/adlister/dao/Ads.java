package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;

import java.sql.SQLException;
import java.util.List;

public interface Ads {

    List<Ad> getAllAds();
    long insertAd(Ad ad);
    Ad getAdById(long id);
    void updateAd(Ad ad);
    void deleteAd(Ad ad);
//    long insertAdCategories(Category category) throws SQLException;

    // get a list of all the ads
    List<Ad> all();
    // insert a new ad and return the new ad's id
    Long insert(Ad ad);

    Ad getOne(long id);
    List<Ad> searchByTitle(String query);


    List<Ad> findAdsByUserId(long userId);


}
