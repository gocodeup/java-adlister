package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

import java.util.List;

public interface Users {
    // find user by username
    User findByUsername(String username);

    // find by email
    User findByEmail(String email);

    // create a new user
    Long insert(User user);

    // update user information
    void update(User user);

    // update user information - password
    void updatePassword(User user);

    // delete us by id
    void delete(Long id);
}
