package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();

    List<Ad> filterByUsername(Long id);
    // insert a new ad and return the new ad's id
    Long insert(Ad ad);
    //edit existing ad
    void update(Ad ad);

    Ad findAdById(long id);

    //delete existing ad
    void destroy(long id);

    //search
    List<Ad> findByKeyword(String query);

    void likeAd(String id);

}
