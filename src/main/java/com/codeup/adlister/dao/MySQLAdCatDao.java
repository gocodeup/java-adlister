package com.codeup.adlister.dao;
import com.codeup.adlister.models.JoinReturns;
import com.mysql.cj.jdbc.Driver;
import com.codeup.adlister.models.AdCat;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdCatDao implements Adcats{
    private Connection connection = null;

    public MySQLAdCatDao(Config config) {
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
    public void deleteAdCat(String id){
        try {
            String query = "DELETE FROM ads_cat WHERE ad_id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, Integer.parseInt(id));
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error finding adCat by id", e);
        }
    }

    @Override

    public List<JoinReturns> getRelated(String ad_id) {
        String query = "SELECT categories.category FROM categories " +
                " JOIN ads_cat ac on categories.id = ac.cat_id " +
                " JOIN ads a on a.id = ac.ad_id " +
                " WHERE ac.ad_id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, Integer.parseInt(ad_id));
            ResultSet rs = stmt.executeQuery();
            return createJoinReturnsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error finding related categories by id", e);
        }
    }

//    @Override
//
//    public List<AdCat> getRelatedAdCat(String ad_id) {
//        String query = "SELECT * FROM ads_cat WHERE ad_id= ?";
//        try {
//            PreparedStatement stmt = connection.prepareStatement(query);
//            stmt.setInt(1, Integer.parseInt(ad_id));
//            ResultSet rs = stmt.executeQuery();
//            return createAdCatsFromResults(rs);
//        } catch (SQLException e) {
//            throw new RuntimeException("Error finding related categories by id", e);
//        }
//    }

    private List<JoinReturns> createJoinReturnsFromResults(ResultSet rs) throws SQLException {
        List<JoinReturns> cats= new ArrayList<>();
        while (rs.next()) {
            cats.add(extractJoinReturns(rs));
        }
        return cats;
    }


    private JoinReturns extractJoinReturns(ResultSet rs) throws SQLException {
        return new JoinReturns(
                rs.getString("category")
        );
    }

    private List<AdCat> createAdCatsFromResults(ResultSet rs) throws SQLException {
        List<AdCat> cats= new ArrayList<>();
        while (rs.next()) {
            cats.add(extractAdCats(rs));
        }
        return cats;
    }

    private AdCat extractAdCats(ResultSet rs) throws SQLException {
        return new AdCat(
                rs.getInt("cat_id"),
                rs.getInt("ad_id")
        );
    }


    @Override
    public void insert(AdCat adCat) {
        String insertQuery = "INSERT INTO ads_cat(cat_id, ad_id) VALUES (?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, adCat.getAdId());
            stmt.setInt(2, adCat.getCatId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error adding CatAd's ", e);
        }
    }
}
