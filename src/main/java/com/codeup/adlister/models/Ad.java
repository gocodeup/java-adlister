package com.codeup.adlister.models;

public class Ad {
    private long id;
    private long userId;
    private String name;
    private String description;
    private double price;
    private String shiny;
    private String type;

    public Ad(long id, long userId, String name, String description, double price, String shiny, String type) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.shiny = shiny;
        this.type = type;
    }

    public Ad(long userId, String name, String description, double price, String shiny, String type) {
        this.userId = userId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.shiny = shiny;
        this.type = type;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getShiny() {
        return shiny;
    }

    public void setShiny(String shiny) {
        this.shiny = shiny;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}