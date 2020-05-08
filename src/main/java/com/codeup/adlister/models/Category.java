package com.codeup.adlister.models;


import java.util.Comparator;

// Category model

public class Category {
        private long id;
        private String name;

    public Category(long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Constructor with only Name
    public Category(String name){
        this.name = name;
    }

    // Getters and Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
