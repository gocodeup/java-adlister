package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();

    List<Ad> myAds();

    List<Ad> myAds(User user);

    // insert a new ad and return the new ad's id
    Long insert(Ad ad);

    Ad findByTitle(String id);

    Ad findById(String id);

    void deleteAd(String id);

    String updateAd(String id, String title, String description);
}
