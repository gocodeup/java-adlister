package com.codeup.adlister.models;

public class Ad {
    private long id;
    private long userId;
    private long categoryId;
    private String title;
    private String description;

    //  CONSTRUCTORS
    public Ad(){}

    public Ad(long userId, String title, String description) {
        this.userId = userId;
        this.title = title;
        this.description = description;
    }

    public Ad(long id, long userId, String title, String description) {
        this.categoryId = categoryId;
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
    }

    public Ad(long id, long userId, long categoryId, String title, String description) {
        this.categoryId = categoryId;
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
    }


    //  GETTERS/SETTERS
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getUserId() {
        return userId;
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
    public long getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }
}
