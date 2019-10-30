package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();
    // insert a new ad and return the new ad's id
    Long insert(Ad ad);

    Ad findAdById(long id);

    List<Ad> adsTitleQuery(String q);

    void delete(long id);

    List<Ad> getAdsByUserId(Long id);
}
