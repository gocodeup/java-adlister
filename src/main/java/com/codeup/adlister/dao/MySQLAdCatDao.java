package com.codeup.adlister.dao;
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
    public List<AdCat> getRelated(String ad_id) {
        String query = "SELECT * FROM categories" +
                " JOIN ads_cat ac on categories.id = ac.cat_id" +
                " JOIN ads a on a.id = ac.ad_id" +
                " WHERE ac.ad_id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, Integer.parseInt(ad_id));
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return createAdCatsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error finding related categories by id", e);
        }

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
    public Long insert(AdCat adCat) {
        try {
            String insertQuery = "INSERT INTO ads_cat(ad_id, cat_id) VALUES (?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, adCat.getAdId());
            stmt.setInt(2, adCat.getCatId());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error adding CatAd's ", e);
        }
    }
}
