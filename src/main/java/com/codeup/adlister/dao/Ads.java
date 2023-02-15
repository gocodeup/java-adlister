package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.sql.SQLException;
import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();
    // insert a new ad and return the new ad's id
    Long insert(Ad ad);

    List<Ad> searchAds(String searchString) throws SQLException;

    Ad findUniqueAdId(Long ad);

    List<Ad> getUserAds(long id);

    void update(Ad editAd);
}
