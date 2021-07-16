package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.sql.SQLException;
import java.util.List;

public interface Ads {
    List<Ad> getAllAds();
    long insertAd(Ad ad);
    Ad getAdById(long id);
    void updateAd(Ad ad);
    void deleteAd(Ad ad);
    int insertAdCategories(long ad_id, long cat_id) throws SQLException;

}
