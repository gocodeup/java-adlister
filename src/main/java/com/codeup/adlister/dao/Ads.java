package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.AdCategory;

import java.sql.SQLException;
import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();
    // insert a new ad and return the new ad's id
    Long insert(Ad ad);
    // get single ad
    Ad findOne(long id) throws SQLException;
    //  from reading should add all CRUD methods to DAO
    void update(Ad ad);
    void delete(Ad ad);

    //added by ND
    List<Ad> findAdByKeyword(String keyword) throws SQLException;
    List<Ad> search(String keyword);

    //show all ads on profile
    List<Ad> allAdsByUserId(long userId);

    Ad findByStringId(String id);
    Ad findById(long id);

    List<AdCategory> getAdsFromCategory(String searchCategory);


//    have these methods here just in case***********************
//    List<Ad> getAdsFromCategory(String category);
//    void removeCategories(Long ad_id);
//    void addCategory(Long ad_id, Long category_id);

}

