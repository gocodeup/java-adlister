package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

import java.util.List;

public interface Users {
    User findByUsername(String username);
    User findById(long id);
    Long insert(User user);
    void editProfile(String newUsername, String newEmail, String newPassword, String username);
}
