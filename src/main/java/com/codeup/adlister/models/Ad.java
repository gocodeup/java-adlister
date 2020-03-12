package com.codeup.adlister.models;

import java.util.List;

public class Ad {

    private int id;
    private int userId;
    private String title;
    private String description;
    private List<String> categories;
    private double price;

    // Default constructor
    public Ad() {
    }

    // Constructor for getting from db
    public Ad(int userId, String title, String description, double price) {
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.categories = null;
        this.price = price;
    }

    public Ad(int id, int userId, String title, String description, List<String> categories, double price) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.categories = categories;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
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

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Ad{" +
                "id=" + id +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", categories=" + categories +
                '}';
    }
}