package com.codeup.adlister.models;

public class Type {
    private Long id;
    private String type;

    public Type(Long id, String type) {
        this.id = id;
        this.type = type;
    }

    public Type(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
