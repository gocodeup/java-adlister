package com.codeup.adlister.models;

public class AdImage {
    private long id;
    private long adId;
    private String imageURL;

    public AdImage(long id, long adId, String imageURL) {
        this.id = id;
        this.adId = adId;
        this.imageURL = imageURL;
    }

    public AdImage(long adId, String imageURL) {
        this.adId = adId;
        this.imageURL = imageURL;
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

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
