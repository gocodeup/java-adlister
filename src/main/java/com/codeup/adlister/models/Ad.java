package com.codeup.adlister.models;


public class Ad {
    private long id;
    private long userId;
    private long catId;
    private String title;
    private String description;
    private String location;
    private int reputation;

    public Ad(long id, long user_id, long cat_id, String title, String description, String location, int reputation) {
        this.id = id;
        this.userId = user_id;
        this.catId = cat_id;
        this.title = title;
        this.description = description;
        this.location = location;
        this.reputation = reputation;
    }

    public Ad(long userId, long catId, String title, String description, String location) {
        this.userId = userId;
        this.catId = catId;
        this.title = title;
        this.description = description;
        this.location = location;
    }

    public Ad(long id, long userId, long catId, String title, String description, String location) {
        this.id = id;
        this.userId = userId;
        this.catId = catId;
        this.title = title;
        this.description = description;
        this.location = location;
    }

    public Ad(long catId, String title, String description, String location, long id){
        this.catId = catId;
        this.title = title;
        this.description = description;
        this.location = location;
        this.id = id;
    }

    public Ad(long userId, String title, String description) {
        this.userId = userId;
        this.title = title;
        this.description = description;
    }

    public Ad(long catId, String title, String description, String location) {
        this.catId = catId;
        this.title = title;
        this.description = description;
        this.location = location;
    }

    public Ad() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public long getCatId() {
        return catId;
    }

    public void setCatId(long catId) {
        this.catId = catId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getReputation() {
        return reputation;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }
}
