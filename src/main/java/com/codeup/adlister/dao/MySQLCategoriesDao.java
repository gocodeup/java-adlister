package com.codeup.adlister.dao;
import com.codeup.adlister.models.Category;
import com.mysql.cj.jdbc.Driver;
import com.codeup.adlister.models.Ad;
import controllers.Config;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLCategoriesDao implements Categories {
    private Connection connection = null;


    public MySQLCategoriesDao(Config config) {
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

    public List<Category> all() {
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("SELECT * FROM categories");
            ResultSet rs = stmt.executeQuery();
            return createCategoriesFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    public List<Category> search(String userInput) {
        PreparedStatement stmt = null;
        try {
            String query = "SELECT * FROM categories WHERE name LIKE ?";
            String queryWildCard = userInput + "%";

            stmt = connection.prepareStatement(query);
            stmt.setString(1, queryWildCard);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return createCategoriesFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving this ad.", e);
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
            throw new RuntimeException("Error creating new ad.", e);
        }
    }

    private Category extractCategory(ResultSet rs) throws SQLException {
        return new Category(
                rs.getLong("id"),
                rs.getString("name")
        );
    }

    private List<Category> createCategoriesFromResults(ResultSet rs) throws SQLException {
        List<Category> categories = new ArrayList<>();
        while (rs.next()) {
            categories.add(extractCategory(rs));
        }
        return categories;
    }
}

//    public static void main(String[] args) {
//        Config config = new Config();
//        List<Ad> test = new MySQLAdsDao(config).search("playstation");
//        System.out.println(test.isEmpty());
//
//        if (!test.isEmpty()) {
//            for (int x = 0; x < test.size(); x++) {
//                System.out.println(test.get(x));
//            }
//        }
//    }
//}

//    @Override
//    public Ad adTitlePick(String title) {
//        return null;
//    }
//}
