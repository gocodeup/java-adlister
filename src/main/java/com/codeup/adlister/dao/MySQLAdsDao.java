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
            //ND->>>>>>>
            stmt = connection.prepareStatement("SELECT * FROM ads.id, ads.user_id, users.username, " +
                    "ads.title, ads.description, ads.adCreated, ads.category"
            + "From ads  JOIN users  ON users.id = ads.user_id");
            ResultSet rs = stmt.executeQuery();
            //return createAdsFromResults(rs);
            List<Ad> allAds = new ArrayList<>();
            while (rs.next()) {
                Ad newAd = new Ad(
                        rs.getLong("id"),
                        rs.getString("username"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("category"),
                        rs.getString("dateCreated")
                );
                allAds.add(newAd);
            }
            return allAds;
//            ND<<<<<<<<<<

        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }
    public void delete(Ad ad) {
        String query = "DELETE FROM ads WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, ad.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting an ad by id", e);
        }
    }

    public void update(Ad ad) {
        String query = "UPDATE ads SET title = (?), description = (?) WHERE id = (?)";
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, ad.getTitle());
            stmt.setString(2, ad.getDescription());
            stmt.setLong(3, ad.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating the existing ad", e);
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
    //need to add arraylist methods, etc. ND
    @Override
    public List<Ad> findAdByKeyword(String keyword) throws SQLException {
        String query = "SELECT *, users.userName FROM ads" +
                "JOIN users" + "ON users.id = ads.user_id" +
                "WHERE ads.title LIKE ?";

        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setString(1, keyword);
        ResultSet rs = pstmt.executeQuery();
        List<Ad> keywordAds = new ArrayList<>();
        while (rs.next()){
//            name of the columns of list? Check on changes as needed. i.e. categories, etc.
            Ad newAd = new Ad(
                    rs.getLong("id"),
                    rs.getString("username"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getString("category"),
                    rs.getString("dateCreated")
//        **  NOTE:**   not sure if we need a created date but added as a placeholder.
                    );
//            check on method for keywordAds//nvm-i need .add for adding to the list.
            keywordAds.add(newAd);
        }
        return keywordAds;
    }

}
