package com.codeup.adlister.models;

public class Ad {
    private long id;
    //ND
    private String dateCreated;
    private String username;
    private String category;

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
    //ND
    public Ad(long id, String username, String title, String description, String category, String dateCreated){
        this.id = id;
        this.username = username;
        this.title = title;
        this.description = description;
        this.category = category;
        this.dateCreated = dateCreated;
    }
    // waiting for changes.

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
