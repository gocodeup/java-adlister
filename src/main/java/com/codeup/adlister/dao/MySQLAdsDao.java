package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.mysql.cj.jdbc.Driver;
import javax.management.RuntimeErrorException;
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

    @Override
    public void updateAd(Long id, String title, String description) {
        // Storing update query in string.
        String updateAdQuery = "UPDATE ads SET title = ?, description = ? WHERE id = ?";
        try {
            // Preparing SQL statement.
            PreparedStatement statement = connection.prepareStatement(updateAdQuery);

            // Setting update query values in "updateAdQuery".
            statement.setString(1, title);
            statement.setString(2, description);
            statement.setLong(3, id);

            // Execute update query.
            statement.executeUpdate();

        } catch (SQLException e)  {
            throw new RuntimeException("Error updating current ad.");
        }
    }


    public List<Ad> findPostByUserId(Long userId) {
        try {
            String findQuery = "SELECT * FROM ads WHERE user_id = ?";
            PreparedStatement stmt1 = connection.prepareStatement(findQuery);
            stmt1.setLong(1, userId);
            return createAdsFromResults(stmt1.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }

    }

    @Override
    public Ad findById(long id) {
        String query = String.format("SELECT * FROM ads WHERE id = %d", id);
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if(rs.next()){
                return extractAd(rs);
            }
            return null;
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

}
