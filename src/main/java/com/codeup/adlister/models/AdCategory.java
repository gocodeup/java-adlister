package com.codeup.adlister.models;

public class AdCategory {
    private long adId;
    private long categoryId;


    public AdCategory(long adId, long categoryId) {
        this.adId = adId;
        this.categoryId = categoryId;
    }

    public long getAdId() {
        return adId;
    }

    public void setAdId(long adId) {
        this.adId = adId;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }
}

