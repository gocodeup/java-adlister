package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

import java.util.List;

public interface Users {
    User findByUsername(String username);
    User findByEmail(String email);
    User updateUserInfo(User user);
    Long insert(User user);
    User deleteUserByUsername(String username);
}
