package com.codeup.adlister.models;

public class Category {
    private int id;
    private int ad_id;
    private int category;

    public Category(int ad_id, int category) {
        this.ad_id = ad_id;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAd_id() {
        return ad_id;
    }

    public void setAd_id(int ad_id) {
        this.ad_id = ad_id;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }
}
