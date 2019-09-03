package com.codeup.adlister.models;

public class Block {
    private int id;
    private String block;

    public Block(int id, String block) {
        this.id = id;
        this.block = block;
    }

    public Block(String block) {
        this.block = block;
    }

    public int getId() {
        return id;
    }

//    public String getId() {return block;}

    public void setId(int id) {
        this.id = id;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }
}
