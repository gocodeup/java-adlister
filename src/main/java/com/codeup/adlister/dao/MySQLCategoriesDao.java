package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;
import controllers.Config;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MySQLCategoriesDao implements Categories {
    private Connection connection = null;

    public MySQLCategoriesDao(Config config) {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    //    creates function to display all categories
    public List<Category> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM categories");
            ResultSet rs = stmt.executeQuery();
            return createCategoriesFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all categories.", e);
        }
    }

    private List<Category> createCategoriesFromResults(ResultSet rs) throws SQLException {
        List<Category> all = new ArrayList<>();
        while (rs.next()) {
            all.add(extractCategory(rs));
        }

        return all;
    }

    private Category extractCategory(ResultSet rs) throws SQLException {
        return new Category(
                rs.getInt("id"),
                rs.getString("name")
        );
    }

    //function to add category
    public Long insert(int id, int categoryId) { // change category ID later to what we are using
        try {
            String query = "INSERT INTO ad_category (category_id, ad_id) VALUES (?, ?)";//change category_id
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, categoryId);//change categoryID
            stmt.setInt(2, id);

            long count = stmt.executeUpdate();
            return count;
        } catch (SQLException e) {
            throw new RuntimeException("Error inserting new category.", e);
        }
    }

    // function to display ads with respective categories
    public List<Category> combined(Ad ad) {
        String query = "SELECT categories.id, categories.name FROM categories JOIN ad_category ON categories.id = ad_category.category_id JOIN categories ON categories.id = ad_category.category_id WHERE ad_id = ?"; // change category to our name after 2nd JOIN and CATEGORY.ID after ON and ad_category.CATEGORY_id before WHERE and CATEGORY.id after WHERE.
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, ad.getId());
            StringBuilder query1;
            ResultSet rs = stmt.executeQuery();
            return createCategoriesFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error getting categories.", e);
        }
    }

    public int deleteCategoriesPerAd(int id) {
        String query = "DELETE FROM ad_category WHERE category_id = ?"; //change category_id to whatever we are using_id
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, id);
            int count = stmt.executeUpdate();

            return count;
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting all categories per ad");
        }
    }
}
