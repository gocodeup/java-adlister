package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

import java.util.List;

public interface Users {
    User findByUsername(String username);

    User findByUserId(long userId);

    Long insert(User user);

    User findByPassword(String password);

    User findByEmail(String email);

    List<User> all();

    void updateUser(User user);
}
