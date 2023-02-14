package com.codeup.adlister.models;

public class Category {
    private int id;
    private String category;

    public Category( int id_,String cat) {
        id = id_;
        category = cat;
    }

    private String GetCat(){
        return this.category;
    }

}
