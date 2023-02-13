package com.codeup.adlister.models;

public class JSON {
    private String response;
    private String redirect;


    public JSON(String response, String redirect) {
        this.response = response;
        this.redirect = redirect;
    }

    public JSON(String response) {
        this.response = response;
        this.redirect = null;
    }
}
