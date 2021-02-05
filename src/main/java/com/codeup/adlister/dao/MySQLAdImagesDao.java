package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.AdImage;
import com.codeup.adlister.models.Config;
import com.mysql.cj.jdbc.Driver;

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
    public AdImage getImageURLByAdId(Long id) {
        String query = "SELECT * FROM ad_images WHERE ad_id = ? LIMIT 1";

        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, id);

            ResultSet rs = stmt.executeQuery();
            rs.next();

            return extractAdImage(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving image.", e);
        }
    }

    private AdImage extractAdImage(ResultSet rs) throws SQLException {
        return new AdImage(
                rs.getLong("id"),
                rs.getLong("ad_id"),
                rs.getString("image_url")
        );
    }
}
