package com.codeup.adlister.models;

public class Favorite {
    private int user_id;
    private int ad_id;

    public Favorite(int userId, int adId) {
        user_id = userId;
        ad_id = adId;
    }
    public int getAdId(){
        return this.ad_id;
    }
    public int getUser_id(){
        return this.user_id;
    }
}
