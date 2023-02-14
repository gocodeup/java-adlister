package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Favorite;
import com.codeup.adlister.models.User;

import java.util.List;

public interface Favorites {



    List<Ad> getRelated(User user);
}
