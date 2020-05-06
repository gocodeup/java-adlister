package com.codeup.adlister.models;

import jdk.jfr.Category;

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

    // Method to convert both (int) id and String name "to strings"
    public String toString(){
        return "{'+this.id+ ' '+this.name+'}";
    }

    // Checks object created from constructor
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        } else if (obj == null){
            return false;
        } else if (obj instanceof jdk.jfr.Category){
            jdk.jfr.Category cat = (jdk.jfr.Category)obj;
            if((cat.getName() == null && name == null) || (cat.getName().equals(name))){
                return true;
            }
        }
        return false;
    }
}
