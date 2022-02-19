package com.codeup.adlister.dao;

import com.codeup.adlister.models.Category;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLCategoriesDao implements Categories {
    private Connection connection = null;

    public MySQLCategoriesDao(Config config) {
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
    public List<Category> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM categories");
            ResultSet rs = stmt.executeQuery();
            return createCatsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all categories.", e);
        }
    }


    @Override
    public Category getCategoryByCatName(String category) {
        String query = "SELECT * FROM categories WHERE category = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, category);
            return extractCategory(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a category", e);
        }
    }

    @Override
    public Long insert(List<Category> categoryObjects) {
        return null;
    }

    @Override
    public List<Category> search(String keyword2) {
        String query = "SELECT * FROM ads WHERE title LIKE ? ";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
//            stmt.setString(1, keyword2);
            // change above code to :
            stmt.setString(1, '%' + keyword2 + '%');
//            stmt.setString(2, keyword);
            ResultSet rs = stmt.executeQuery();
            return createCatsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error finding ad", e);
        }
    }

//    @Override
//    public Category getAdsInsert(Category category) {
//
//    }

    private Category extractCategory(ResultSet rs) throws SQLException {
//        if (! rs.next()) {
//            return null;
//        }
        return new Category(
                rs.getLong("id"),
                rs.getString("category")
        );
    }

    private List<Category> createCatsFromResults(ResultSet rs) throws SQLException {
        List<Category> categories = new ArrayList<>();
        while (rs.next()) {
            categories.add(extractCategory(rs));
        }
        return categories;
    }
}
