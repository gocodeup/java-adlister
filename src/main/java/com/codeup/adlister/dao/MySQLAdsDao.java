package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.mysql.cj.api.mysqla.result.Resultset;
import com.mysql.cj.jdbc.Driver;

import controllers.Config;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection = null;
    private List<Ad> ads;

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
    public Ad getById(long id) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads WHERE id = ?");
            stmt.setLong(1, id); // First "?" in query above will be replaced with an individual ad's id
            ResultSet rs = stmt.executeQuery();
//            rs.next();
//            return extractAd(rs); // Will return a single ad object
            return createAdsFromResults(rs).get(0);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving ad id=" + id, e);
        }
    }

    public List<Ad> getAllById(List<Integer> ids) {
        List<Ad> results = new ArrayList<>();
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads WHERE id = ?");
            for(int i = 0; i <= ids.size()-1; i++) {
                stmt.setLong(1, ids.get(i));
                ResultSet rs = stmt.executeQuery();
                rs.next();
                results.add(extractAd(rs));
            }
            return results;
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving ads by id");
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
    public List<Ad> getByTitle(String adTitle) {
        this.ads = new ArrayList<>();
        try {
            String titleQuery = "SELECT * FROM ads WHERE title LIKE ?";

            PreparedStatement stmt = connection.prepareStatement(titleQuery);
            stmt.setString(1, "%"+adTitle+"%");
//            stmt.setString(1, "%"+adTitle+"%");
            ResultSet rs = stmt.executeQuery();
//            if (rs.next()) {
                while(rs.next()){
                    ads.add(extractAd(rs));
                }
//            } else {
//                return null;
//            }
            return ads;
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving an ad.", e);
        }
    }

    @Override
    public int updateAd(Ad ad) {
        String query = "UPDATE ads SET title = ?, description = ? where id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, ad.getTitle());
            stmt.setString(2, ad.getDescription());
            stmt.setInt(3, (int) ad.getId());
            int count = stmt.executeUpdate();
            return count;
        } catch (SQLException e) {
            throw new RuntimeException("Error updating ad posting", e);
        }
    }

    @Override
    public void deleteAd(int deladID) {
      String query = "DELETE FROM ads WHERE id = ?";
    }

    @Override
    public Object findById(long id) {
        return null;
    }

    public Ad extractAd(ResultSet rs) throws SQLException {
        // must call rs.next on new resultSet before calling this
        return new Ad(
                rs.getLong("id"),
                rs.getLong("user_id"),
                rs.getString("title"),
                rs.getString("description")
        );
    }
    @Override
    public List<Ad> createAdsFromResults(ResultSet rs) {
        this.ads = new ArrayList<>();
        try {
            while (rs.next()) {
                ads.add(extractAd(rs));
            }
            return ads;
        } catch (SQLException e){
            return this.ads;
        }
    }
}
