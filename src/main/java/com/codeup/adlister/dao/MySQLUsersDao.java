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



//**************************FIND BY USERNAME**************************************
    @Override
    public User findByUsername(String username) {
        String query = "SELECT * FROM users WHERE username = ? LIMIT 1";
        try {
            System.out.println(username);
            System.out.println(query);
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


    //**********************UPDATE USER*********************************
    @Override
    public void update(User user,String name,String email,String password) {
        String query = "UPDATE users " +
                " SET " +
                " username = ?," +
                "  email = ? " +
                "  password = ?" +
                "WHERE username = " + user.getUsername() + "";

        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1,name );
            stmt.setString(2,email);
            stmt.setString(3, password);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();

        } catch (SQLException e) {
            throw new RuntimeException("Error creating new user", e);

        }
    }





    //*******************************DELETE USER*********************************
    @Override
    public void delete(User user) {
        String query = "DELETE users " +
                "WHERE username = " + user.getUsername() + "";

        try {
            PreparedStatement stmt = connection.prepareStatement(query);
           stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error creating new user", e);

        }




    }

    @Override
    public User findByEmail(String email) {
        String query = "SELECT * FROM users WHERE email = ? LIMIT 1";
        try {
            System.out.println(email);
            System.out.println(query);
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, email);
            return extractUser(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by username", e);
        }

    }


    private User extractUser(ResultSet rs) throws SQLException {
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
