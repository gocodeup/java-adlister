package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();
    // insert a new ad and return the new ad's id
    Long insert(Ad ad);

    List<Ad> userAds(Long user_id);
    Ad thisAd(String id);
    List<Ad> thisAdById(Long id);
    Long insertCat(Long id, int category);
    List<Ad> deleteThisAd(Long id);

}
