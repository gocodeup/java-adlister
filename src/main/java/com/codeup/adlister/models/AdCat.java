package com.codeup.adlister.models;

public class AdCat {
    private int catId;
    private int adId;

    public AdCat(int ad_id, int cat_id){
        this.adId = ad_id;
        this.catId = cat_id;
    }

    public int getAdId(){
        return this.adId;
    }
    public int getCatId(){
        return this.catId;
    }
}
