package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

public interface Users {

    //used to find a user by "username"
    long findByUsername(String username);

    //used to find a user by "password"
    User findByPassword(String password);

    //used to find a user by "email"
    User findByEmail(String email);

    //used to find a user by "id"
    User findByUserId(long id);

    //used to add a user to our database
    Long insert(User user);

    //used to update password
    int updatePassword(User user);

    int updateUser(String email, String username);
}
