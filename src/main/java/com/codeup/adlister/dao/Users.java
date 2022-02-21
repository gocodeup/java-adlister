package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

import java.sql.SQLException;
import java.util.List;

public interface Users {
    User findByUsername(String username);
    Long insert(User user);

    void delete(String user);
    void update(User user);
    //  findByid needed in order to grab from 1:n relation with ads
    User findById(long id);

    boolean validateEmail(String username) throws SQLException;
    boolean validateUsername(String username) throws SQLException;
    boolean validatePassword(String password) throws SQLException;
}