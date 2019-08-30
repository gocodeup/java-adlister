package com.codeup.adlister.dao;

import com.codeup.adlister.models.Block;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLBlocksDao implements Blocks{
    private Connection connection = null;

    public MySQLBlocksDao(Config config) {
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
    public List<Block> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM blocks");
            ResultSet rs = stmt.executeQuery();
            return createBlocksFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all blocks.", e);
        }
    }

    private Block extractBlock(ResultSet rs) throws SQLException {
        return new Block(
                rs.getInt("id"),
                rs.getString("block")
        );
    }

    private List<Block> createBlocksFromResults(ResultSet rs) throws SQLException {
        List<Block> blocks = new ArrayList<>();
        while (rs.next()) {
            blocks.add(extractBlock(rs));
        }
        return blocks;
    }


}
