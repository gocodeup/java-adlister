package com.codeup.adlister.dao;
import com.codeup.adlister.models.Category;
import com.codeup.adlister.models.Ad;

import com.mysql.cj.api.mysqla.result.Resultset;
import com.mysql.cj.jdbc.Driver;
import controllers.Config;


import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MySQLCategoriesDao implements Categories {
    private Connection connection = null;
    private ArrayList<String> categories;



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


    //    creates function to display all categories
    public List<Category> all() {
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("SELECT * FROM categories");
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return createCategoriesFromResultsCategoryList(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all categories.", e);
        }
    }


    private List<Category> createCategoriesFromResultsCategoryList(ResultSet rs) throws SQLException {
        List<Category> categories = new ArrayList<>();
        while (rs.next()) {
            categories.add(extractCategory(rs));
        }
        return categories;
    }





    //function to add category
    public int insert(int id, int categoryId) { // change category ID later to what we are using
        return 0;
    }


    public List<String> search(String userInput) {
        PreparedStatement stmt = null;
        try {
            String query = "SELECT * FROM categories WHERE name LIKE ?";
            String queryWildCard = "%" + userInput + "%";

            stmt = connection.prepareStatement(query);
            stmt.setString(1, queryWildCard);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return createCategoriesFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving this ad.", e);
        }
    }

//    public Long insert(Ad ad) {
//        try {
//            String query = "INSERT INTO ad_category (category_id, ad_id) VALUES (?, ?)";//change category_id
//            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
//            stmt.setInt(1, categoryId);//change categoryID
//            stmt.setInt(2, id);
//            long count = stmt.executeUpdate();
//            return count;
//        } catch (SQLException e) {
//            throw new RuntimeException("Error inserting new category.", e);
//        }
//    }


    // function to display ads with respective categories
    public List<Category> combined(Ad ad) {
        String query = "SELECT categories.id, categories.name FROM categories JOIN ad_category ON categories.id = ad_category.category_id JOIN categories ON categories.id = ad_category.category_id WHERE ad_id = ?"; // change category to our name after 2nd JOIN and CATEGORY.ID after ON and ad_category.CATEGORY_id before WHERE and CATEGORY.id after WHERE.
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, ad.getId());
            StringBuilder query1;
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return createCategoriesFromResultsCategoryList(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error getting categories.", e);
        }
    }


    public List<Ad> allAdsByCategory(String category){
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads JOIN ad_category ON ads.id = ad_category.ad_id JOIN" +
                    " categories c2 on ad_category.category_id = c2.id WHERE c2.name LIKE ?");
            stmt.setString(1, "%"+category+"%");
                ResultSet rs = stmt.executeQuery();
                return DaoFactory.getAdsDao().createAdsFromResults(rs);
            } catch (SQLException e) {
                throw new RuntimeException("Error getting ads with designated category.", e);
            }

    }

    @Override
    public ArrayList<String> findByAdId(long id) {
       ResultSet rs;
        String query = "SELECT * FROM categories JOIN ad_category ON categories.id = ad_category.category_id WHERE" +
                " ad_category.ad_id = ? ORDER BY ad_category.ad_id DESC";
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, id);
           rs = stmt.executeQuery();
            return createCategoriesFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error getting categories.", e);
        }
    }

    private Category extractCategory(ResultSet rs) throws SQLException {
        return new Category(
                rs.getInt("id"),
                rs.getString("name")
        );
    }

    @Override
    public ArrayList<String> createCategoriesFromResults(ResultSet rs) {
        this.categories = new ArrayList<>();
        try {
            while (rs.next()) {
                categories.add(extractCategory(rs).getName());
            }
            return categories;
        } catch (SQLException e){
            return this.categories;
        }
    }




    public int deleteCategoriesPerAd(int id) {
        String query = "DELETE FROM ad_category WHERE ad_id = ?"; //change category_id to whatever we are using_id
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, id);
            int count = stmt.executeUpdate();
            return count;
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting all categories per ad");
        }
    }
}
