package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class MySQLUsersDao implements Users {
    private Connection connection;

    public MySQLUsersDao(Config config) {
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
    public User findByUsername(String username) {
        String query = "SELECT * FROM users WHERE username = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            return extractUser(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by username", e);
        }
    }

    @Override
    public Long insert(User user) {
        String query = "INSERT INTO users(username, email, password) VALUES (?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating new user", e);
        }
    }

    @Override
    public User findByUserID(long id) {
        String query = "SELECT * FROM users WHERE id = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, id);
            return extractUser(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by username", e);
        }
    }

    @Override
    public User findByAd(long ad_id) {
        String query = "SELECT * from users where id in (select user_id FROM ads where id = ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, ad_id);
            ResultSet rs = stmt.executeQuery();
            System.out.println(rs);
//            rs.next();
            return extractUser(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error finding ad username", e);
        }
    }

    @Override
    public void updateUser(User user) {
        //updates only password and email
        String updateSql = "UPDATE users set password = ?, email = ? where id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(updateSql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getPassword());
            stmt.setString(2, user.getEmail());
            stmt.setLong(3, user.getId());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            // testing for the expected messages.
            System.out.println(stmt);
            System.out.println(stmt.executeUpdate());

        } catch (SQLException e) {
            throw new RuntimeException("Error Editing an Ad by ID", e);
        }

    }




    @Override
    public User findByUserEmail(String email) {
        String query = "SELECT * FROM users WHERE email = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, email);
            return extractUser(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by email", e);
        }

    }

    @Override
    public void deleteByID(long id) {
        String query = "DELETE FROM users WHERE id = ? LIMIT 1";//? will be replaced by the ID to be deleted
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, id);
            System.out.println(stmt);
            System.out.println(stmt.executeQuery());
            stmt.execute();// EXECUTES A QUERY
        } catch (SQLException e){
            throw new RuntimeException("Error deleting a User by ID, e");
        }

    }

    private User extractUser(ResultSet rs) throws SQLException {
        if (! rs.next()) {
            return null;
        }
        return new User(
            rs.getLong("id"),
            rs.getString("username"),
            rs.getString("email"),
            rs.getString("password")
        );
    }

}
