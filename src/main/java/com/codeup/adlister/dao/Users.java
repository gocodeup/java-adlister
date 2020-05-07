package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

import java.util.List;

public interface Users {
    User findByUsername(String username);

    User findByPassword(String password);

    User findByEmail(String email);

    User findByUserId(long id);

    Long insert(User user);

    int updateUser(User user);
}
