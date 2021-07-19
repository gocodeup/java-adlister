package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLCategoryDao implements Categories {
    private Connection connection = null;

    public MySQLCategoryDao(Config config) {
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
    public Category getCategoryById(long id) {
        Category category = null;

        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM ad_categories WHERE cat_id = ?");
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                category = new Category(
                        rs.getLong("id"),
                        rs.getLong("adId")


                );
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving ad from the database", e);
        }

        return category;
    }
    @Override
    public long insertAdCategories(Category category) throws SQLException {
        try {
            String query = "INSERT INTO ad_categories (ad_id, cat_id) VALUES (? ,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setLong(1, category.getAdId());
            ps.setLong(2, category.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving category from the database", e);
        }
        return 0L;

    }

    @Override
    public List<String> printCategories(long ad_id) {
        try {
            String query = "SELECT title FROM categories WHERE id IN (SELECT cat_id FROM ad_categories WHERE ad_id = ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, ad_id);
            ResultSet rs = preparedStatement.executeQuery();
            List<String> cats = new ArrayList<>();
            while (rs.next()) {
                cats.add(rs.getString("title"));
            }
            return cats;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<String> printCategories() {
        return null;
    }


//    private List<Ad> createCategoriesFromResults(ResultSet rs) throws SQLException {
//        List<Category> categories = new ArrayList<>();
//        while (rs.next()) {
//            categories.add(extractAd(rs));
//        }
//        return categories;
//    }

//    @Override
//    public List<Category> getAllCategories() {
//        PreparedStatement stmt = null;
//        try {
//            stmt = connection.prepareStatement("SELECT * FROM ads");
//            ResultSet rs = stmt.executeQuery();
//            return createAdsFromResults(rs);
//        } catch (SQLException e) {
//            throw new RuntimeException("Error retrieving all ads.", e);
//        }
//    }
}
