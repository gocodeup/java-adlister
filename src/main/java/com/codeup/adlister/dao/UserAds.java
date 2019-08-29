package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.util.List;

public interface UserAds {
    //Show only logged in users ads on their profile page
    List<Ad> userAds();
}
