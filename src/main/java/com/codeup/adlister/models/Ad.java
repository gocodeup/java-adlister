package com.codeup.adlister.models;

import java.util.ArrayList;
import java.util.Objects;

public class Ad {
    private long id;
    private long userId;
    private String title;
    private String description;
    private ArrayList<JoinReturns> categories;

    public Ad(long id, long userId, String title, String description, ArrayList<JoinReturns> categories) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.categories = categories;
    }

    public Ad(long userId, String title, String description) {
        this.userId = userId;
        this.title = title;
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

    public ArrayList<JoinReturns> getCategories(){
        return this.categories;
    }
}
