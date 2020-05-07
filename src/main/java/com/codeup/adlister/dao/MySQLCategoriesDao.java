package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.controllers.Config;
import com.codeup.adlister.models.Category;
import com.mysql.jdbc.Driver;


import javax.servlet.jsp.jstl.core.Config;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class MySQLCategoriesDao implements Categories {
    private Connection connection = null;

    public MySQLCategoriesDao(Config config) {
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

//    creates function to display all categories

    public List<Category> all(){
        PreparedStatement stmt = null;
        try{
            stmt = connection.prepareStatement("SELECT * FROM categories");
            ResultSet rs = stmt.executeQuery();
            return createCategoriesFromResults(rs);
        } catch (SQLException e){
            throw new RuntimeException("Error retrieving all categories.", e);
        }
    }

    private List<Category> createCategoriesFromResults(ResultSet rs) throws SQLException{
        List<Category> all = new ArrayList<>();
        while (rs.next()){
            all.add(extractCategory(rs));
        }

        return all;
    }

    private Category extractCategory(ResultSet rs) throws SQLException{
        return new Category(
                rs.getInt("id"),
                rs.getString("name")
                );
    }

    //function to add category

    public Long insert(int id, int categoryId){ // change category ID later to what we are using
        try{
            String query = "INSERT INTO ad_category (category_id) VALUES (?, ?)";//change category_id
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, categoryId);//change categoryID
            stmt.setInt(2, id);

            long count = stmt.executeUpdate();
            return count;
        } catch (SQLException e){
            throw new RuntimeException("Error inserting new category.", e);
        }
    }

    // function to display ads with respective categories
    public List<Category> combined(Ad ad){
        String query = "SELECT categories.id, categories.name FROM categories JOIN ad_category ON categories.id = ad_category.category_id JOIN category ON category.id = ad_category.category_id WHERE ad.id = ?;"; // change category to our name after 2nd JOIN and CATEGORY.ID after ON and ad_category.CATEGORY_id before WHERE and CATEGORY.id after WHERE.
        try{
            PreparedStatement stm = connection.prepareStatement(query);
            stmt.setInt(1, category.getId());
            StringBuilder query1;
            ResultSet rs = stm.executeQuery();
            return createCategoriesFromResults(rs);
        } catch (SQLException e){
            throw new RuntimeException("Error getting categories.", e);
        }
    }

    public int deleteCategoriesPerAd(int id){
        String query = "DELETE FROM ad_category WHERE category_id = ?"; //change category_id to whatever we are using_id
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, id);
            int count = stmt.executeUpdate();

            return count;
        } catch (SQLException e){
            throw new RuntimeException("Error deleting all categories per ad");
        }
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
