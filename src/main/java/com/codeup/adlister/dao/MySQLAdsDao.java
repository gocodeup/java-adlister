package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Config;
import com.codeup.adlister.models.Type;
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
                    config.getUsername(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public List<Ad> all() {
        String query = "SELECT * FROM ads";

        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public Long insert(Ad ad) {
        String insertQuery = "INSERT INTO ads(user_id, name, description, price, shiny, type, image_url) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getName());
            stmt.setString(3, ad.getDescription());
            stmt.setDouble(4, ad.getPrice());
            stmt.setString(5, ad.getShiny());
            stmt.setString(6, ad.getType());
            stmt.setString(7, ad.getImageURL());

            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();

            return rs.getLong(1);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    @Override
    public void update(Ad ad) {
        String query = "UPDATE ads SET name = ?, description = ?, price = ?, shiny = ?, type = ?, image_url = ?  WHERE id = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, ad.getName());
            stmt.setString(2, ad.getDescription());
            stmt.setDouble(3, ad.getPrice());
            stmt.setString(4, ad.getShiny());
            stmt.setString(5, ad.getType());
            stmt.setString(6, ad.getImageURL());
            stmt.setLong(7, ad.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        String query = "DELETE FROM ads WHERE id = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, id);

            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Ad findAdById(Long id) {
        String query = "SELECT * FROM ads WHERE id = ? LIMIT 1";

        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, id);

            ResultSet rs = stmt.executeQuery();
            rs.next();

            return extractAd(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving ad.", e);
        }
    }

    @Override
    public List<Ad> findAdsByUserId(Long id) {
        String query = "SELECT * FROM ads WHERE user_id = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, id);

            ResultSet rs = stmt.executeQuery();


            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public List<Ad> findAdsByName(String search) {
        String query = "SELECT * FROM ads WHERE name LIKE ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, "%" + search + "%");

            ResultSet rs = stmt.executeQuery();

            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving ads.", e);
        }
    }

    @Override
    public List<Ad> findAdsByType(String type) {
        String query = "SELECT * FROM ads WHERE type LIKE ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, "%" + type + "%");

            ResultSet rs = stmt.executeQuery();

            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving ads.", e);
        }
    }

    private Ad extractAd(ResultSet rs) throws SQLException {
        return new Ad(
                rs.getLong("id"),
                rs.getLong("user_id"),
                rs.getString("name"),
                rs.getString("description"),
                rs.getDouble("price"),
                rs.getString("shiny"),
                rs.getString("type"),
                rs.getString("image_url")
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