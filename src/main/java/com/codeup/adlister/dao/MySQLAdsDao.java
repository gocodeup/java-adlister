package com.codeup.adlister.dao;
import com.codeup.adlister.models.*;
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

    @Override
    public List<Ad> myAds() {
        return null;
    }

    @Override
    public List<Ad> myAds(User user) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads JOIN users u on u.id = ads.user_id WHERE ads.user_id ="+user.getId());
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving your ads.", e);
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
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    private Ad extractAd(ResultSet rs) throws SQLException {
        return new Ad(
            rs.getLong("id"),
            rs.getLong("user_id"),
            rs.getString("title"),
            rs.getString("description"),
                (ArrayList<JoinReturns>) DaoFactory.getAdCatsDao().getRelated(String.valueOf(rs.getLong("id")))
        );
    }

    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }

    @Override
    public List<Ad> searchResults(String words, List<ReturnedCats> cats){
            int count = 3;
        try {
            words = "%"+words+"%";
            String query = "SELECT DISTINCT ads.id, ads.user_id, ads.title, ads.description FROM ads WHERE (title LIKE ? OR  description LIKE ?)";
            if(!cats.isEmpty()){
                for (int i = 1; i <= cats.size(); i++){
                    query = query + "AND ads.id IN (SELECT ad_id FROM ads_cat WHERE cat_id = ?)";
                }
            }

            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, words);
            stmt.setString(2, words);
            if(!cats.isEmpty()){
                for (ReturnedCats cat : cats){
                    stmt.setString(count, cat.getId());
                    count++;
                }
            }
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving search ads.", e);
        }

    }


    @Override
    public Ad findByTitle(String title) {
        String query = "SELECT * FROM ads WHERE title = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, title);
            ResultSet rs = stmt.executeQuery();
            if(!rs.next()){
                return null;
            }
            else{
                return extractAd(rs);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error finding ad by Title", e);
        }
    }

    @Override
    public Ad findById(String id) {
        String query = "SELECT * FROM ads WHERE id = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, Integer.parseInt(id));
            ResultSet rs = stmt.executeQuery();
            rs.next();
             return extractAd(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error finding ad by id", e);
        }
    }

    @Override
    public void deleteAd(String id) {
            try {
            String query = "DELETE FROM ads WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, Integer.parseInt(id));
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error finding ad by id", e);
        }
    }

    @Override
    public String updateAd(String id, String title, String description) {
        String query = "UPDATE ads SET title = ?, description = ? WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, title);
            stmt.setString(2, description);
            stmt.setInt(3, Integer.parseInt(id));
            stmt.executeUpdate();
            return "updated";
        } catch (SQLException e) {
            throw new RuntimeException("Error finding ad by id and updating", e);
        }
    }


}
