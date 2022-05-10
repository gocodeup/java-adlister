package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.mysql.cj.jdbc.Driver;

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
            stmt = connection.prepareStatement("SELECT * FROM sa_lister_db.ads");
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    public List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }

    @Override
    public Long insert(Ad ad) {
        try {
            String insertQuery = "INSERT INTO sa_lister_db.ads(user_id, cat_id, title, description, location) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getUserId());
            stmt.setLong(2, ad.getCatId());
            stmt.setString(3, ad.getTitle());
            stmt.setString(4, ad.getDescription());
            stmt.setString(5, ad.getLocation());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }


    @Override
    public void update(Ad ad) {
        try {
            String insertQuery = "UPDATE sa_lister_db.ads SET cat_id = ?, title = ?, description = ?, location = ? WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(insertQuery);
            stmt.setLong(1, ad.getCatId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());
            stmt.setString(4, ad.getLocation());
            stmt.setLong(5, ad.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating ad.", e);
        }
    }

    @Override
    public Ad findAdById(long id) {
        String query = "SELECT * FROM sa_lister_db.ads WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                return extractAd(rs);
            } else {
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error searching for ads by id", e);
        }
    }


    private Ad extractAd(ResultSet rs) throws SQLException {
        return new Ad(
            rs.getLong("id"),
            rs.getLong("user_id"),
            rs.getLong("cat_id"),
            rs.getString("title"),
            rs.getString("description"),
            rs.getString("location")
        );
    }


    @Override
    public void destroy(Ad ad) {

    }


} //end