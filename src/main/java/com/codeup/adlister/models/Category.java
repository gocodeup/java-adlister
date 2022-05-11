package com.codeup.adlister.models;

public class Category {
    private long id;
    private long ad_id;
    private String category;

    public Category(long id, long ad_id, String category){
        this.id = id;
        this.ad_id = ad_id;
        this.category = category;
    }

    public Category(long ad_id, String category){
        this.ad_id = ad_id;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public long getAd_id() {
        return ad_id;
    }

    public String getCategory() {
        return category;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAd_id(long ad_id) {
        this.ad_id = ad_id;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
