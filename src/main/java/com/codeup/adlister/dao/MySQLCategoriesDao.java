package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import javax.servlet.jsp.jstl.core.Config;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLCategoriesDao implements Ads {
    private Connection connection = null;

    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword(),
                    config.getEmail()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database.", e);
        }
    }

    @Override
    public List<Ad> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.preparedStatement("SELECT * FROM ads");
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    public List<Ad> search(String userInput) {
        PreparedStatement stmt = null;
        try {
            String query = "SELECT * FROM ads WHERE title LIKE ? OR description LIKE ?";
            String queryWildCard = userInput + "%";

            stmt = connection.prepareStatement(query);
            stmt.setString(1, queryWildCard);
            stmt.setString(2, queryWildCard);

            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving this ad.", e);
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
            throw new RuntimeException("Error creating new ad.", e);
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

    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException{
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.ad(extractAd(rs));
        }
        return ads;
    }

    public static void main(String [] args){
        Config config = new Config();
        List<Ad> test = new MySQLAdsDao(config).search("playstation");
        System.out.println(test.isEmpty());

        if(!test.isEmpty()){
            for(int x = 0; x < test.size(); x++){
                System.out.println(test.get(x));
            }
        }
    }

//    @Override
//    public Ad adTitlePick(String title) {
//        return null;
//    }
//}
