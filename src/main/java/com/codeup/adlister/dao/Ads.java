package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();
    // insert a new ad and return the new ad's id
    Long insert(Ad ad);


    void update(Ad ad,String title,String description);




   Ad ByTitle(String title);

    void delete(Ad ad);

     List<Ad> findAd(long userId);

    List<Ad> searchAD(String tittle);

}



