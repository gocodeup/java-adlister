package com.codeup.adlister.models;

public class Category {
    long id;
    private long adId;
    private String category;


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Category(long id, long adId) {
        this.id = id;
        this.adId = adId;
    }
    public Category(long id, long adId, String category) {
        this.id = id;
        this.adId = adId;
        this.category = category;
    }
    public Category(String category) {
        this.category = category;
    }
    public Category(long id, String category){
        this.id = id;
        this.category = category;
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