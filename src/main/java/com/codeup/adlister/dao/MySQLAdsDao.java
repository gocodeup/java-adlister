package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;
import com.mysql.cj.jdbc.Driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection = null;

    public MySQLAdsDao(Config config) {
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
    public List<Ad> getAllAds() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads");
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public long insertAd(Ad ad) {
        return 0;
    }

    @Override



    public List<Ad> findAdsByUserId(long userId) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads WHERE user_id = ?");
            stmt.setLong(1, userId);
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public Long insert(Ad ad) {

        try {
            String insertQuery = "INSERT INTO ads(user_id, title, description) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    @Override
    public Ad getOne(long id) {
        return null;
    }

    @Override
    public List<Ad> searchByTitle(String query) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads WHERE title LIKE ?");
            stmt.setString(1, query);
            ResultSet rs = stmt.executeQuery();
//            stmt.executeUpdate();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    private Ad extractAd(ResultSet rs) throws SQLException {
        return new Ad(
            rs.getLong("id"),
            rs.getLong("user_id"),
            rs.getString("title"),
            rs.getString("description")
        );
    }

    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }
    @Override
    public Ad getAdById(long id) {
        Ad ad = null;

        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM ads WHERE id = ?");
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                ad = new Ad(
                rs.getLong("id"),
                rs.getLong("user_id"),
                rs.getString("title"),
                rs.getString("description")

                );
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving ad from the database", e);
        }

        return ad;
    }

    @Override
    public void updateAd(Ad ad) {
        try{
            PreparedStatement stmt = connection.prepareStatement("UPDATE ads SET title=?, description=? WHERE id=?");


            stmt.setString(1, ad.getTitle());
            stmt.setString(2, ad.getDescription());
            stmt.setLong(3, ad.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error updating Ad information", e);
        }
    }

    @Override
    public void deleteAd(Ad ad) {
        try{
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM ad_categories WHERE ad_id = ?");
            stmt.setLong(1, ad.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error updating Profile information", e);
        }

    }

    @Override
    public List<Ad> all() {
        return null;
    }
//    @Override
//    public long insertAdCategories(Category category) throws SQLException {
//        String query = "INSERT INTO ad_categories (ad_id, cat_id) VALUES (? ,?)";
//        PreparedStatement ps = connection.prepareStatement(query);
//        ps.setLong(1, category.getAdId());
//        ps.setLong(2, category.getId());
//        ps.executeQuery();
//        return 0L;
//    }

}
