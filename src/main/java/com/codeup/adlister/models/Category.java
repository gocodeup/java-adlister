package com.codeup.adlister.models;

public class Category {
    long id;
    private long adId;


    public Category(long id, long adId) {
        this.id = id;
        this.adId = adId;
    }
    public Category() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAdId() {
        return adId;
    }

    public void setAdId(long adId) {
        this.adId = adId;
    }
}