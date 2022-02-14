package com.codeup.adlister.models;

public class Category {
    private long id;
    private long adId;
    private String name;

    //  CONSTRUCTORS
    public Category(){}

    public Category(String name){
        this.name = name;
    }

    public Category(long id, long adId, String name){
        this.id = id;
        this.adId = adId;
        this.name = name;
    }

    //  GETTERS/SETTERS

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
