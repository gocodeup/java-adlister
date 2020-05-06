package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

import java.util.List;

public interface Users {
    User findByUsername(String username);

    User findByUserId(Long userId);

    Long insert(User user);

    User findByUserId(long userId);
}
