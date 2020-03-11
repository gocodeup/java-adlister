//package com.codeup.adlister.dao;
//
//
//import com.codeup.adlister.models.Ad;
//import com.mysql.cj.jdbc.Driver;
//
//import javax.xml.transform.Result;
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class MySQLCategoriesDao implements Categories {
//
//    private Connection connection = null;
//
//    public MySQLCategoriesDao(Config config) {
//        try {
//            DriverManager.registerDriver(new Driver());
//            connection = DriverManager.getConnection(
//                    config.getUrl(),
//                    config.getUsername(),
//                    config.getPassword()
//            );
//        } catch (SQLException e) {
//            throw new RuntimeException("Error connecting to the database!", e);
//        }
//    } //MySQLCategories
//
//    @Override
//    public List<String> findCategory(int id) {
//        PreparedStatement stmt = null;
//
//        List<String> categories = new ArrayList<>();
//
//        try {
//
//            String query = "SELECT category FROM categories JOIN ad_category ON ad_category.category_id = categories.id\n" +
//                    " JOIN ads ON ads.id = ad_category.ad_id WHERE ads.id = ?";
//
//
//            stmt = connection.prepareStatement(query);
//
//            stmt.setInt(1, id);
//
//            ResultSet rs = stmt.executeQuery();
//
//            while(rs.next()) {
//
//                categories.add(rs.getString("category"));
//            }
//
//
//        } catch(SQLException e) {
//            throw new RuntimeException("Error finding the categories.", e);
//        }
//
//        return categories;
//    } //findCategory()
//
//    @Override
//    public void insert(int id, Ad ad) {
//        try {
//
//
//            for(String element : ad.getCategories()) {
//                String insertQuery = "INSERT INTO ad_category(ad_id, category_id) VALUES (?, ?)";
//
//                PreparedStatement stmt = connection.prepareStatement(insertQuery);
//
//                stmt.setInt(1, id);
//                stmt.setInt(2, Integer.parseInt(element));
//                stmt.executeUpdate();
//            }
//
//
//        } catch(SQLException e) {
//            throw new RuntimeException("Unable to add categories", e);
//        }
//
//
//    }
//
//    @Override
//    public void deleteCategories(int id) {
//        try{
//            String query = "DELETE FROM ad_category WHERE ad_id = ?";
//            PreparedStatement stmt = connection.prepareStatement(query);
//
//            stmt.setInt(1,id);
//
//            stmt.executeUpdate();
//        }catch (SQLException e){
//            throw new RuntimeException("Error deleting categories",e);
//        }
//    }
//
//}
//
//
//
