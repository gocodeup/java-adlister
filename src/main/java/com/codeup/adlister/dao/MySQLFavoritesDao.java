package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLFavoritesDao implements Favorites {
    private Connection connection = null;

    public MySQLFavoritesDao(Config config) {
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
    public void deleteAdFav(String id){
        try {
            String query = "DELETE FROM ads_fav WHERE ad_id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, Integer.parseInt(id));
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error finding adFav by id", e);
        }
    }

    @Override
    public List<Ad> getRelated(User user) {
        String query = "SELECT ads.id FROM ads " +
                " JOIN ads_fav af on ads.id = af.ad_id " +
                " JOIN users u on af.user_id = u.id" +
                 "  WHERE u.id =?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, user.getId());
            ResultSet rs = stmt.executeQuery();
            List<Ad> returnedAds = new ArrayList<>();
            if(!rs.next()){
                return null;
            }
            else{
                while(rs.next()){
                    returnedAds.add(DaoFactory.getAdsDao().findById(String.valueOf(rs.getInt("id"))));
                }
                return returnedAds;
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error finding favorites by id", e);
        }

    }

}
