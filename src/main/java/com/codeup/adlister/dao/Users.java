package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

import java.util.List;

public interface Users {
    User findByUsername(String username);


    Long insert(User user);
    void update(User user,String name,String email,String password);
    void delete(User user);

    User findByEmail(String email);
}
