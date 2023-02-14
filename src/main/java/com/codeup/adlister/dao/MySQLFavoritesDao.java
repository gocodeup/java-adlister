package com.codeup.adlister.dao;

import com.codeup.adlister.models.Favorite;
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
    public List<Favorite> getRelated(User user) {
        String query = "SELECT * FROM ads" +
                " JOIN ads_fav af on ads.id = af.ad_id" +
                " JOIN users u on af.user_id = u.id" +
                " WHERE u.id =?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, user.getId());
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return createFavoritesFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error finding favorites by id", e);
        }

    }
    private List<Favorite> createFavoritesFromResults(ResultSet rs) throws SQLException {
        List<Favorite> favs = new ArrayList<>();
        while (rs.next()) {
            favs.add(extractFavorites(rs));
        }
        return favs;
    }

    private Favorite extractFavorites(ResultSet rs) throws SQLException {
        return new Favorite(
                rs.getInt("user_id"),
                rs.getInt("ad_id")
        );
    }
}
