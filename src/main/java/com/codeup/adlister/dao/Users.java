package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

import java.util.List;

public interface Users {
    User findByUsername(String username);
    Long insert(User user);
    User findByUserID(long id);
    void updateUser(User user);
    User findByUserEmail(String email);
    void deleteByID(long id);
    User findByAd(long ad_id);
}
