package com.codeup.adlister.dao;

import com.codeup.adlister.models.AdCategory;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class MySQLAdsCategoriesDao implements AdsCategories {
    private Connection connection = null;

    public MySQLAdsCategoriesDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }


    @Override
    public Boolean insert(AdCategory adCategory) {
        try {
            String insertQuery = "INSERT INTO ads_categories(ads_id, categories_id) VALUES (?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, adCategory.getAds_id());
            stmt.setLong(2, adCategory.getCategories_id());
            stmt.executeUpdate();
            //ResultSet rs = stmt.getGeneratedKeys();
            //rs.next();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException("Error adding advertisement to category.", e);
        }
    }





}