package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

import java.util.List;

public interface Users {
    User findByUsername(String username);
    Long insert(User user);
    User findByUserID(long id);
    void updateUserPassword(long id, String hashPassword);
    void updateUserEmail(long id, String  email);
    User findByUserEmail(String email);
    void deleteByID(long id);
}
