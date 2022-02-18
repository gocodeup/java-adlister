package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.sql.SQLException;
import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();
    // insert a new ad and return the new ad's id
    Long insert(Ad ad);
    // get single ad
//    Ad findOne(long id) throws SQLException;
    //  from reading should add all CRUD methods to DAO
    void update(Ad ad);
    void delete(Ad ad);

    //added by ND
    List<Ad> findAdByKeyword(String keyword) throws SQLException;

    //show all ads on profile
    List<Ad> allAdsByUserId(long userId);


    Ad findById(Long id);
}
