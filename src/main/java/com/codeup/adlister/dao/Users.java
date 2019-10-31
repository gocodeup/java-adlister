package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

public interface Users {
    User findByUsername(String username);

    // Find user by user id and return string of their name
    User findById(Long id);

    Long insert(User user);

    void deleteUser(String u);

    void deleteUser(Long id);
}
