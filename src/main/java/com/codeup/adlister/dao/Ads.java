package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Type;

import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();

    // insert a new ad and return the new ad's id
    Long insert(Ad ad);

    // update ad information
    void update(Ad ad);

    // delete ad by id
    void delete(Long id);

    // find ad by id - to display single ad
    Ad findAdById(Long id);

    // find ads by user id - display ads by user
    List<Ad> findAdsByUserId(Long id);

    // find ads by Pokemon name
    List<Ad> findAdsByName(String search);

    // find ads by Pokemon Type
    List<Ad> findAdsByType(String type);
}
