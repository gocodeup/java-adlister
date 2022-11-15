package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
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
    public List<Ad> all() {
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

    public Ad findByUserID(long user_id)
    {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads WHERE user_id = ? LIMIT 1");
            stmt.setLong(1, user_id);
            return (Ad) extractAd(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding ads by user_id", e);
        }
    }
    @Override
    public List<Ad> findByTitle(String search)
    {
        String query = "SELECT * FROM ads WHERE title = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, search);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            System.out.println("Below is our search results");
//            return new Ad(
//                    rs.getLong("id"),
//                    rs.getLong("user_id"),
//                    rs.getString("title"),
//                    rs.getString("description")
//            );
            return createAdsFromResults(stmt.executeQuery());
        } catch (SQLException e) {
//            throw new RuntimeException("Error finding ads by search", e);
            throw new RuntimeException(e.toString());
        }
    }

    @Override
    public List<Ad> findByID(Long user_id) {
        String query = "SELECT * FROM ads WHERE user_id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, user_id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return createAdsFromResults(stmt.executeQuery());
        } catch (SQLException e) {
//            throw new RuntimeException("Error finding ads by search", e);
            throw new RuntimeException(e.toString());
        }
    }

    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            System.out.println("next result set");
            ads.add(extractAd(rs));
        }
        return ads;
    }

    private Ad extractAd(ResultSet rs) throws SQLException {
//        if (! rs.next()) {
//            return null;
//        }
            System.out.println("Current result set " + rs);
            System.out.println("result set id: " + rs.getLong("id"));
            System.out.println("result set title: " + rs.getString("title"));
            return new Ad(
                    rs.getLong("id"),
                    rs.getLong("user_id"),
                    rs.getString("title"),
                    rs.getString("description")
            );
//        }
    }
}
