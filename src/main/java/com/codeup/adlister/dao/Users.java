package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

public interface Users {
    User findByUsername(String username);

    Long insert(User user);

    User getUserByAd(long id);

    void update(User editUser);
}
