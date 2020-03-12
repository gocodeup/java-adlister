package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class MySQLAdsDao implements Ads {
    private static Connection connection = null;

    public MySQLAdsDao(Config config) {
//        DecimalFormat df = new DecimalFormat("###.###");
//        System.out.println(df.format(3.12456));

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

    public static List<Ad> allFiltered(int category) {
        try {
            String SubtractQuery = "Select * from ad_category where category_id =?";
            PreparedStatement stmt = connection.prepareStatement(SubtractQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, category);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public int insert(Ad ad) {
        try {
            String insertQuery = "INSERT INTO ads (user_id, title, description, price) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, ad.getUserId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());
            stmt.setDouble(4, ad.getPrice());


            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    public void addtoAdCategoryTable(int adId, int catId) throws SQLException {
        String addCat = "INSERT INTO ad_category (ad_id, category_id) VALUES (? , ?)";
        PreparedStatement stmtAddCat = connection.prepareStatement(addCat, Statement.RETURN_GENERATED_KEYS);
        stmtAddCat.setInt(1, adId);
        stmtAddCat.setInt(2, catId);
        stmtAddCat.executeUpdate();
    }

    private static Ad extractAd(ResultSet rs) throws SQLException {
            return new Ad(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getString(3),
                    rs.getString(4),
                    getCategoryByAdId(rs.getInt(5)),
                    //1?
                    rs.getDouble(6)
            );
    }

    private static List<String> getCategoryByAdId(int ad_id) throws SQLException {
        List<String> categoryList = new ArrayList<>();

        String getCategoryByIDstmt = "SELECT * FROM ad_category WHERE ad_id = ?";
        PreparedStatement catById = connection.prepareStatement(getCategoryByIDstmt, Statement.RETURN_GENERATED_KEYS);
        catById.setInt(1, ad_id);
        catById.executeQuery();
        ResultSet rs = catById.getResultSet();
        while(rs.next()){
            categoryList.add(Integer.toString(rs.getInt("category_id")));
        }
        // TODO- do a query to get the categories by adId
        return categoryList;
    }

    private static List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }
    // select a certain id from the database
    public List<Ad> adDetails(int id) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads WHERE id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving ad", e);
        }
    }

}
