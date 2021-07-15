package com.codeup.adlister.dao;
import com.codeup.adlister.models.User;

public interface Users {
    User findByUsername(String username);

    User findByEmail(String email);

    Long insert(User user);

    User findByUserId(long id);
}
