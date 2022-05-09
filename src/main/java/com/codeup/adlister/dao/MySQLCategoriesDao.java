package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLCategoriesDao implements Categories{
    private Connection connection;

    public MySQLCategoriesDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch(SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public List<Category> all() {
        String query = "SELECT * FROM categories";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            return createCategoriesFromList(rs);
        } catch(SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public List<Ad> findByCategory(String category) {
        String query = "SELECT * FROM ads JOIN categories c ON c.id = ads.cat_id WHERE category = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, category);
            ResultSet rs = stmt.executeQuery();

            Config config = new Config();
            MySQLAdsDao util = new MySQLAdsDao(config);
            List<Ad> ads = new ArrayList<>();
            while(rs.next()){
                ads.add(util.extractAd(rs));
            }

            return ads;
        } catch(SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    private Category extractCategory(ResultSet rs) throws SQLException {
        return new Category(
                rs.getLong("id"),
                rs.getString("category")
        );
    }

    private List<Category> createCategoriesFromList(ResultSet rs) throws SQLException {
        List<Category> categories = new ArrayList<>();
        while (rs.next()) {
            categories.add(extractCategory(rs));
        }
        return categories;
    }

//    private Ad extractAd(ResultSet rs) throws SQLException {
//        return new Ad(
//                rs.getLong("id"),
//                rs.getLong("user_id"),
//                rs.getLong("cat_id"),
//                rs.getString("title"),
//                rs.getString("description"),
//                rs.getString("location")
//        );
//    }
}
