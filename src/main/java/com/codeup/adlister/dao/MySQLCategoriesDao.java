package com.codeup.adlister.dao;

import com.codeup.adlister.models.Category;
import com.mysql.cj.jdbc.Driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
            stmt = connection.prepareStatement("SELECT * FROM categories order by category");
            ResultSet rs = stmt.executeQuery();
            return createCategoriesFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all categories.", e);
        }
    }

    public List<Category> allCategoriesForAd(long adId) {
        PreparedStatement stmt = null;

        try {
            stmt = connection.prepareStatement("Select * from categories inner join ads_categories on categories.id = ads_categories.ads_id inner join ads on ads_categories.categories_id = ads.id WHERE ads.id = ?");
            stmt.setLong(1, adId);
            ResultSet rs = stmt.executeQuery();
            return createCategoriesFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public Category showCategory(long id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("SELECT * FROM categories WHERE id = ?");
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            rs.next();
            return extractCategory(rs);
        } catch (SQLException e) {
            throw new RuntimeException("error showing ad", e);
        }
    }

    @Override
    public Long insert(Category category) {
        try {
            String insertQuery = "INSERT INTO categories(id, category) VALUES (?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, category.getId());
            stmt.setString(2, category.getCategory());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new category.", e);
        }
    }

    private static Category extractCategory(ResultSet rs) throws SQLException {
        return new Category(
                rs.getLong("id"),
                rs.getString("category")
        );
    }

    public static List<Category> createCategoriesFromResults(ResultSet rs) throws SQLException {
        List<Category> categories = new ArrayList<>();
        while (rs.next()) {
            categories.add(extractCategory(rs));
        }
        return categories;
    }

    @Override
    public void deleteCategory(Long categoryId) {

        //Delete all references to this category from the ads_categories table
        String deleteQuery = "DELETE FROM ads_categories WHERE categories_id = ?;";
        try {
            PreparedStatement stmt = connection.prepareStatement(deleteQuery);
            stmt.setLong(1, categoryId);
            stmt.executeUpdate();

            //Now that there are no references to this category we can delete the actual category from the categories table
            deleteQuery = "DELETE FROM categories WHERE id = ?;";
            try {
                stmt = connection.prepareStatement(deleteQuery);
                stmt.setLong(1, categoryId);
                stmt.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException("Cannot delete category", e);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Cannot delete category", e);
        }



    }


}