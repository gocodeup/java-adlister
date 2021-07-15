package com.codeup.adlister.models;

public class AdCategory {
    private long ads_id;
    private long categories_id;

    public AdCategory(long ads_id, long categories_id) {
        this.ads_id = ads_id;
        this.categories_id = categories_id;
    }


    public long getAds_id() {
        return ads_id;
    }

    public void setAds_id(long ads_id) {
        this.ads_id = ads_id;
    }

    public long getCategories_id() {
        return categories_id;
    }

    public void setCategories_id(long categories_id) {
        this.categories_id = categories_id;
    }
}

