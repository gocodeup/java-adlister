package com.codeup.adlister.models;

public class Category {
    private int id;
    private String category;

    public Category( int id_,String cat) {
        this.id = id_;
        this.category = cat;
    }

    public String getCategory(){
        return this.category;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int _id){
        this.id = _id;
    }

    public void setCategory(String cat){
        this.category=cat;
    }

}
