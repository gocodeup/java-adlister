package com.codeup.adlister.dao;

import com.codeup.adlister.models.Category;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;

import static java.lang.Long.parseLong;

public class CategoryDao implements Categories {

    private Connection conn = null;

    public CategoryDao(Config config){
        try {
            DriverManager.registerDriver(new Driver());
            conn = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public Long insert(Long adId, Long cat) {
//        Category cate = new Category(Long adId, Long cat);
        try {
            String insertQuery = "INSERT INTO ad_cat (ad_id, cat_id) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(insertQuery);
            stmt.setLong(1, adId);
            stmt.setLong(2, cat);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    return 0L;
    }
}





