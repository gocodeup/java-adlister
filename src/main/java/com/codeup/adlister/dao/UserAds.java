package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import java.util.List;

public interface UserAds {
    //Show only logged in users ads on their profile page
//    List<Ad> userAds(Long user_id);
    List<Ad> userAds(Long user_id);
}
