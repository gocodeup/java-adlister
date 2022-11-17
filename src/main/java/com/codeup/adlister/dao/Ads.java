package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.util.List;

public interface Ads
{
    // get a list of all the ads
    List<Ad> all();

    // insert a new ad and return the new ad's id
    Long insert(Ad ad);

    // update exisiting ad
    void updateAd(Long id, String title, String description);


    void delete(long id);


    //method for finding posts by userid
    List<Ad> findPostByUserId(Long userId);

    Ad findById(long id);

}
