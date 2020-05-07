package com.codeup.adlister.dao;

import com.codeup.adlister.models.AdImage;
import com.mysql.cj.jdbc.Driver;
import controllers.Config;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdImagesDao implements AdImages {
    private Connection connection = null;

    public MySQLAdImagesDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public List<AdImage> getImagesByAdId(long adId) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ad_images WHERE ad_id = ?");
            stmt.setLong(1, adId); // First "?" in query above will be replaced with an individual ad's id
            ResultSet rs = stmt.executeQuery();
//            rs.next();
//            return extractAd(rs); // Will return a single ad object
            return createAdImagesFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving ad id=" + adId, e);
        }
    }

    @Override
    public Long insert(AdImage adImg) {
        try {
            String insertQuery = "INSERT INTO ad_images(ad_id, path) VALUES (?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, adImg.getAdId());
            stmt.setString(2, adImg.getPath());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error adding image to add.", e);
        }
    }

    private AdImage extractAdImage(ResultSet rs) throws SQLException {
        // must call rs.next on new resultSet before calling this
        return new AdImage(
                rs.getLong("id"),
                rs.getLong("ad_id"),
                rs.getString("path")
        );
    }

    private List<AdImage> createAdImagesFromResults(ResultSet rs) throws SQLException {
        List<AdImage> adImages = new ArrayList<>();
        while (rs.next()) {
            adImages.add(extractAdImage(rs));
        }
        return adImages;
    }

}
