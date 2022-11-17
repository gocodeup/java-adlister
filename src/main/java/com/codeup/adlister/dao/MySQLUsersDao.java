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
    public void updateUser(Long id, String username, String email, String password) {
        // Storing update query in string.
        String updateUserQuery = "UPDATE users SET username = ?, email = ?, password = ? WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(updateUserQuery);

            // Setting values of "?" in update user query.
            statement.setString(1, username);
            statement.setString(2, email);
            statement.setString(3, password);
            statement.setLong(4, id);

            // Execute update query.
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error updating user information.");
        }
    }

    @Override
    public void deleteUser(Long id) {
        String deleteUserQuery = "DELETE FROM users WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(deleteUserQuery);

            // Setting value of question mark in SQL query to the id that's being passed in as parameter.
            statement.setLong(1, id);

            // Executing delete user query.
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting user.");
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
