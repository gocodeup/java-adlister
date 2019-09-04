package com.codeup.adlister.dao;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class MySQLAdsDao implements Ads, UserAds {
    private Connection connection;
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
//            stmt = connection.prepareStatement("SELECT * FROM ads");
            stmt = connection.prepareStatement("SELECT ads.id as ads_id, ads.user_id as user_id, ads.title as title, ads.description as description, ads.date as date, ads.blocks_id as blocks_id, blocks.block as block, adscategories.categories_id as categories_id, categories.category as category FROM ads LEFT JOIN blocks ON ads.blocks_id = blocks.id LEFT JOIN adscategories ON ads.id = adscategories.ad_id LEFT JOIN categories ON adscategories.categories_id = categories.id;");
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults2(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }
    @Override
    public List<Ad> userAds(Long user_id) {
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("SELECT ads.id as ads_id, ads.user_id as user_id, ads.title as title, ads.description as description, ads.date as date, ads.blocks_id as blocks_id, blocks.block as block, adscategories.categories_id as categories_id, categories.category as category FROM ads LEFT JOIN blocks ON ads.blocks_id = blocks.id LEFT JOIN adscategories ON ads.id = adscategories.ad_id LEFT JOIN categories ON adscategories.categories_id = categories.id WHERE user_id = ?");
            stmt.setLong(1, user_id);
            ResultSet rs = stmt.executeQuery();
            return createUserAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving user ads.", e);
        }
    }

    private List<Ad> createUserAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> userAds = new ArrayList<>();
        while (rs.next()) {
            userAds.add(extractAd2(rs));
        }
        return userAds;
    }
    @Override
    public Long insert(Ad ad) {
        try {
            String insertQuery = "INSERT INTO ads(user_id, title, description, date, blocks_id) VALUES (?, ?, ?, ?,?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());
            stmt.setDate(4, ad.getDate());
            stmt.setInt(5, ad.getBlocksId());
//            stmt.setInt(6, ad.getCategoriesId());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
//            rs.getString("block");

            return rs.getLong(1);

        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }
    public Long insertCat(Long id, int category) {
        try {
            String insertQuery = "INSERT INTO adscategories(ad_id, categories_id) VALUES (?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery);
            int idtwo = id.intValue();
            stmt.setInt(1, idtwo);
            stmt.setInt(2, category);
            stmt.execute();
            return null;

        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad cat.", e);
        }
    }
    private Ad extractAd(ResultSet rs) throws SQLException {
        return new Ad(
            rs.getLong("ads_id"),
            rs.getLong("user_id"),
            rs.getString("title"),
            rs.getString("description"),
            rs.getDate("date"),
            rs.getInt("blocks_id")
        );
    }

    private Ad extractAd2(ResultSet rs) throws SQLException {
        return new Ad(
                rs.getLong("ads_id"),
                rs.getLong("user_id"),
                rs.getString("title"),
                rs.getString("description"),
                rs.getDate("date"),
                rs.getInt("blocks_id"),
                rs.getString("block"),
                rs.getString("category")
        );
    }

    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }

    private List<Ad> createAdsFromResults2(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd2(rs));
        }
        return ads;
    }

    public Ad thisAd(String id) {
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("SELECT ads.id as ads_id, ads.user_id as user_id, ads.title as title, ads.description as description, ads.date as date, ads.blocks_id as blocks_id, blocks.block as block, adscategories.categories_id as categories_id, categories.category as category FROM ads LEFT JOIN blocks ON ads.blocks_id = blocks.id LEFT JOIN adscategories ON ads.id = adscategories.ad_id LEFT JOIN categories ON adscategories.categories_id = categories.id WHERE user_id = ?");
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            return extractAd(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving ad "+ id, e);
        }
    }

    public List<Ad> thisAdById(Long id) {
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("SELECT ads.id as ads_id, ads.user_id as user_id, ads.title as title, ads.description as description, ads.date as date, ads.blocks_id as blocks_id, blocks.block as block FROM ads LEFT JOIN blocks ON ads.blocks_id = blocks.id WHERE ads.id = ?");
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults2(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving ad "+ id, e);
        }
    }
    public List<Ad> deleteThisAd(Long id) {
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("delete FROM ads WHERE id = ?");
            stmt.setLong(1, id);
            stmt.execute();
            return null;
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving ad "+ id, e);
        }
    }

}
