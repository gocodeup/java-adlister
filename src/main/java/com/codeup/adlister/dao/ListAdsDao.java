package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListAdsDao implements Ads {
    private List<Ad> ads;
    private Connection connection = null;

    public List<Ad> all() {
        if (ads == null) {
            ads = generateAds();
        }
        return ads;
    }

    public Long insert(Ad ad) {
        // make sure we have ads
        if (ads == null) {
            ads = generateAds();
        }
        // we'll assign an "id" here based on the size of the ads list
        // really the dao would handle this
        ad.setId((long) ads.size());
        ads.add(ad);
        return ad.getId();
    }

    public Ad findByUserID(long userID){
        List<Ad> newAds = new ArrayList<>();
        newAds.add((Ad) DaoFactory.getAdsDao().all());

        List<Ad> returnAds = new ArrayList<>();

        for(Ad ad : newAds)
        {
            if(userID == ad.getUserId())
            {
                returnAds.add(ad);
            }
        }

        return (Ad) returnAds;
    }

    private List<Ad> generateAds() {
        List<Ad> ads = new ArrayList<>();
        ads.add(new Ad(
            1,
            1,
            "playstation for sale",
            "This is a slightly used playstation"
        ));
        ads.add(new Ad(
            2,
            1,
            "Super Nintendo",
            "Get your game on with this old-school classic!"
        ));
        ads.add(new Ad(
            3,
            2,
            "Junior Java Developer Position",
            "Minimum 7 years of experience required. You will be working in the scripting language for Java, JavaScript"
        ));
        ads.add(new Ad(
            4,
            2,
            "JavaScript Developer needed",
            "Must have strong Java skills"
        ));
        return ads;
    }

    private Ad extractAd(ResultSet rs) throws SQLException {
        return new Ad(
                rs.getLong("id"),
                rs.getLong("user_id"),
                rs.getString("title"),
                rs.getString("description")
        );
    }

    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            System.out.println("next result set");
            ads.add(extractAd(rs));
        }
        return ads;
    }
    @Override
    public List<Ad> findByTitle(String search)
    {
        String query = "SELECT * FROM ads WHERE title LIKE ? ";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, search);
            return createAdsFromResults(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding ads by search", e);
        }
    }

    public List<Ad> findByID(Long user_id)
    {
        String query = "SELECT * FROM ads WHERE user_id = ? ";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, user_id);
            return createAdsFromResults(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding ads by search", e);
        }
    }

}
