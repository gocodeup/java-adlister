package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.AdCategory;
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
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, ad.getTitle());
            stmt.setString(2, ad.getDescription());
            stmt.setLong(3, ad.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating the existing ad", e);
        }
    }


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

    //  need to finish this method
    @Override
    public Ad findOne(long id) throws SQLException {
        String singleAdQuery = "SELECT * FROM ads WHERE id = ?";
        PreparedStatement stmt;
        stmt = connection.prepareStatement(singleAdQuery);
        stmt.setLong(1, id);
        ResultSet rs = stmt.executeQuery();
        //  rs.next() - is used to get next in row
        //  otherwise error page will be reached
        //  if condition would be used if possibility of rs.next() == null
        //  since each ad has an id none should return null therefore condition not needed
        rs.next();
        return extractAd(rs);
    }


//     @Override
//     public List<Ad> findAdByKeyword(String keyword) throws SQLException {
//         return null;
//     }

    //need to add arraylist methods, etc. ND
//    @Override
//    public List<Ad> findAdByKeyword(String keyword) throws SQLException {
//        String query = "SELECT *, users.userName FROM ads\n + ";
//
////        prepped statement
//        //while(rs.nets())
//        return null;
//    }

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
        while (rs.next()) {
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


    //shows all of the current users ads in the profile by userid
//@Override
    public List<Ad> allAdsByUserId(long userId) {
        String query = "SELECT * FROM ads WHERE user_id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, userId);
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error: cannot retrieve ads", e);
        }
    }

    public Ad findByStringId(String id) {
        String findquery = "SELECT * FROM ads WHERE id like (?)";
        try{
            PreparedStatement stmt = connection.prepareStatement(findquery);
            stmt.setString(1, id);
            ResultSet rs =stmt.executeQuery();
            rs.next();
            return extractAd(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error finding the ad by string id");
        }
    }

    @Override
    public Ad findById(long id) {
        try{
            String query = "SELECT * FROM ads WHERE id = ? LIMIT 1";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, String.valueOf(id));
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                return extractAd(rs);
            }
            return null;
        }catch (SQLException e) {
            throw new RuntimeException("Error finding Ad by Id", e);
        }

    }

    @Override
    public List<AdCategory> getAdsFromCategory(String searchCategory) {
        return null;
    }

    @Override
    public List<Ad> search(String keyword) {
        String query = "SELECT * FROM ads WHERE title LIKE ? OR description LIKE ?";
        try{
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, '%' + keyword + '%');
            pstmt.setString(2, '%' + keyword + '%');
            ResultSet rs = pstmt.executeQuery();
            return createAdsFromResults(rs);
        }catch (SQLException e) {
            throw new RuntimeException("Error find the ad", e);
        }
    }

//    @Override
//    public List<Ad> getAdsFromCategory(String category) {
//        return null;
//    }
//
//    @Override
//    public void removeCategories(Long ad_id) {
//
//    }
//
//    @Override
//    public void addCategory(Long ad_id, Long category_id) {

    }
