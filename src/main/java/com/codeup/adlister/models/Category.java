package com.codeup.adlister.models;

import java.util.Comparator;

// Category model
public class Category {
    private int id;
    private String name;

    // General constructor
    public Category(){}

    // Constructor with both Id and Name
    public Category(int id, String name){
        this.id = id;
        this.name = name;
    }

    // Constructor with only Name
    public Category(String name){
        this.name = name;
    }

    // Getters and Setters
    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }
}
