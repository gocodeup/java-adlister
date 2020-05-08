package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;
import com.mysql.cj.jdbc.Driver;

import controllers.Config;

import java.sql.*;

public class MySQLUsersDao implements Users {
    private Connection connection;

    public MySQLUsersDao(Config config) {
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

    @Override
    public long findByUsername(String username) {
        String query = "SELECT * FROM users WHERE username = ? LIMIT 1";
        return getUser(username, query);
//        try {
//            PreparedStatement stmt = connection.prepareStatement(query);
//            stmt.setString(1, username);
//            return extractUser(stmt.executeQuery());
//        } catch (SQLException e) {
//            throw new RuntimeException("Error finding a user by username", e);
//        }
//    }

        @Override
        public User findByUserId ( long userId){
            String query = "SELECT * FROM users WHERE id = ? LIMIT 1";
            try {
                PreparedStatement stmt = connection.prepareStatement(query);
                stmt.setLong(1, userId);
                return extractUser(stmt.executeQuery());
            } catch (SQLException e) {
                throw new RuntimeException("Error finding this user", e);
            }
        }

        @Override
        public User findByPassword (String password){
            String query = "SELECT * FROM users WHERE password = ? LIMIT 1";
            try {
                PreparedStatement stmt = connection.prepareStatement(query);
                stmt.setString(1, password);
                return extractUser(stmt.executeQuery());
            } catch (SQLException e) {
                throw new RuntimeException("Error finding a user by username", e);
            }
        }

        @Override
        public User findByEmail (String email){
            String query = "SELECT * FROM users WHERE email = ? LIMIT 1";
            return getUser(email, query);
//        try {
//            PreparedStatement stmt = connection.prepareStatement(query);
//            stmt.setString(1, email);
//            return extractUser(stmt.executeQuery());
//        } catch (SQLException e) {
//            throw new RuntimeException("Error finding a user by username", e);
//        }
//    }

            @Override
            public int updateUser (User user){
                String query = "UPDATE users SET username = ?, email = ? where id = ?";
                try {
                    PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                    stmt.setString(1, user.getUsername());
                    stmt.setString(2, user.getEmail());
                    stmt.setInt(3, (int) user.getId());
                    int count = stmt.executeUpdate();
                    return count;
                } catch (SQLException e) {
                    throw new RuntimeException("Error updating user information", e);
                }
            }

            @Override
            public int updatePassword (User user){
                String update = "UPDATE user SET password = ? WHERE username = ?";
                try {
                    PreparedStatement stmt = connection.prepareStatement(update);
                    stmt.setString(1, Password.hash(user.getPassword()));
                    stmt.setString(2, user.getUsername());
                    stmt.executeUpdate();
                    return 0;
                } catch (SQLException e) {
                    throw new RuntimeException("Error updating password", e);
                }
            }

            @Override
            public Long insert(User user) {
                String query = "INSERT INTO users(username, email, password) VALUES (?, ?, ?)";
                try {
                    PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                    stmt.setString(1, user.getUsername());
                    stmt.setString(2, user.getEmail());
                    stmt.setString(3, Password.hash(user.getPassword()));
                    stmt.executeUpdate();
                    ResultSet rs = stmt.getGeneratedKeys();
                    rs.next();
                    return rs.getLong(1);
                } catch (SQLException e) {
                    throw new RuntimeException("Error creating new user", e);
                }
            }

            private User extractUser (ResultSet rs) throws SQLException {
                if (!rs.next()) {
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
    }
}