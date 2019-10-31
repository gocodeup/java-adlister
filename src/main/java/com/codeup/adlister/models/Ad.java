package com.codeup.adlister.models;

public class Ad {
    private long id;
    private long userId;
    private String title;
    private String category;
    private String description;
    private String username;

    public Ad(long id, long userId, String title, String category, String description, String username) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.category = category;
        this.description = description;
        this.username = username;
    }

    public Ad(long id, long userId, String title, String category, String description) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.category = category;
        this.description = description;
    }

    public Ad(long userId, String title, String category, String description) {
        this.userId = userId;
        this.title = title;
        this.category = category;
        this.description = description;
    }

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
}
