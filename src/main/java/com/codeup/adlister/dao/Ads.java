package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();

    // get a single ad by id
    Ad getById(long id);

    // insert a new ad and return the new ad's id
    Long insert(Ad ad);

    //Take a single ad and post information
    List<Ad> getByTitle(String title);
}
