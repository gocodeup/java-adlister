package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();
    // insert a new ad and return the new ad's id
    Long insert(Ad ad);
    Ad findByUserID(long userID);
    List<Ad> findByTitle(String search);

    List<Ad> findByID(Long user_id);
//    List<Ad> findByTitle(String search);
}
