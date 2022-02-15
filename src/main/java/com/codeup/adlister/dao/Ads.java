package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.sql.SQLException;
import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();
    // insert a new ad and return the new ad's id
    Long insert(Ad ad);
    // get a single add to return
    Ad findById(Long ad);
    //find ads by their ids
    Ad findByID(Long id);
    //Searching ads by title
    List<Ad> searchByTitle(String query);
    //listing ads on profile page
    List<Ad> findByUserID(Long userId);

    void deleteByID(Long id);
    void editByID(Long id, String newTitle, String newDesc);
    List<Ad> listByCatID(Long catID);
}
