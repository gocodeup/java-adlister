package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();
    List<Ad> getAds(String description);
    // insert a new ad and return the new ad's id
    Long insert(Ad ad);

    Ad getAdById(Long id);

    List<Ad> findAdByUserId(User user);



    //do I come up with a new method in adds??


}
