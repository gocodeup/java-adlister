package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Config;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
// will implement the Users interface
// needs to have a connection object
public class MySQLUsersDao implements Users {
    private Connection connection;
//connect to the users database using the Config for getting the url and a username
    //and password that have privileges on that database
    //register a driver to the connection
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

// override the interface methods

    //find a username by set a query to a string
    // use a prepared statement to make the query
    // set the parameters at the first parameter index to username
    //this method takes in a String which will be the username
    //will return the user by using the extractUser method, which takes in a ResultSet
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

//same as above method except it takes in and email string
    @Override
    public User findByEmail(String email) {
        String query = "SELECT * FROM users WHERE email = ? LIMIT 1";

        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, email);

            return extractUser(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by email", e);
        }
    }

    //makes a String query using MySQL
    //takes in a User
    //prepared statement that takes in a query generated keys
    //set the value parameters, and execute the statement
    //the result set is the generated key which will be returned
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

    // will not return anything because it is an update
    // make a String query and execute that query
    // update only username and email
    @Override
    public void update(User user) {
        String query = "UPDATE users SET username = ?, email = ? WHERE id = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setLong(3, user.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // will not return anything because it is an update
    // make a String query and execute that query
    // able to update password
    @Override
    public void updatePassword(User user) {
        String query = "UPDATE users SET username = ?, email = ?, password = ? WHERE id = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setLong(4, user.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //will not return anything, just deletes from database
    //deletes by taking user id
    //make String query, prepared statement---> execute
    @Override
    public void delete(Long id) {
        String query = "DELETE FROM users WHERE id=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, id);

            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // returns a user and takes in a ResultSet
    //if there is no user return null
    // if there is a user return a new user and get the id, username, email, and password
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
