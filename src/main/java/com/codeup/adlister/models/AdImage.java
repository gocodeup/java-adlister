package com.codeup.adlister.models;

public class AdImage {
    private long id;
    private long adId;
    private String path;

    public AdImage(long id, long adId, String path) {
        this.id = id;
        this.adId = adId;
        this.path = path;
    }

    public AdImage(long id, String path) {
        this.id = id;
        this.path = path;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
