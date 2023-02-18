package com.codeup.adlister.models;

public class JSON {
    private String name;



    public JSON(String response) {
        this.name = response;
    }

    public String getName(){
        return this.name;
    }
}
