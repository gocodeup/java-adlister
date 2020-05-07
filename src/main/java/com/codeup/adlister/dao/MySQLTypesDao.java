package com.codeup.adlister.dao;

import com.codeup.adlister.models.Config;
import com.codeup.adlister.models.Type;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLTypesDao implements Types {
    private Connection connection = null;

    public MySQLTypesDao(Config config) {
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
    public List<Type> all() {
        String query = "SELECT * FROM types";

        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            return createTypesFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all types.", e);
        }
    }

    private Type extractType(ResultSet rs) throws SQLException {
        return new Type(
                rs.getLong("id"),
                rs.getString("type")
        );
    }

    private List<Type> createTypesFromResults(ResultSet rs) throws SQLException {
        List<Type> types = new ArrayList<>();
        while (rs.next()) {
            types.add(extractType(rs));
        }
        return types;
    }
}
