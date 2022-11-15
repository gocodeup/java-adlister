package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
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
            stmt = connection.prepareStatement("SELECT * FROM ads");
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }






    //****************************INSERT AD*********************************
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



    //************************UPDATE ADS********************************************

    @Override
    public void update(Ad ad) {

            String query = "UPDATE ads " +
                    " SET " +
                    " title = ?, " +
                    " description = ? " +

                    "WHERE title = " + ad.getTitle()+"";


        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, ad.getTitle());
            stmt.setString(2, ad.getDescription());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();


        } catch (SQLException e) {
            throw new RuntimeException("Error creating new user", e);

        }



    }





    //****************************DELETE ADS************************************************

    @Override
    public void delete(Ad ad) {

        String query = "DELETE ads " +
                "WHERE title = " + ad.getTitle() + "";

        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();

        } catch (SQLException e) {
            throw new RuntimeException("Error creating new user", e);

        }



    }



 //********************************   FIND ADS  ****************************************************


    @Override
    public Ad findAd(long userId, String title) {
String query = "SELECT * FROM ads WHERE title = ? AND  user_id = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, title);
            stmt.setLong(2, userId);
            ResultSet rs = stmt.executeQuery();
        return  extractAd(rs);


        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }




//****************************SEARCH AD BY TITLE**********************************
    @Override
    public List<Ad> searchAD(String tittle) {

        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads WHERE title =? ");
            stmt.setString(1,tittle);
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
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
