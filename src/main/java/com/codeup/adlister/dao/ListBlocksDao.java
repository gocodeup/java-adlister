package com.codeup.adlister.dao;



import com.codeup.adlister.models.Block;

import java.util.ArrayList;
import java.util.List;

public class ListBlocksDao {

    private List<Block> blocks;


    public List<Block> all() {
        if (blocks== null) {
            blocks= generateBlocks();
        }
        return blocks;
    }

    private List<Block> generateBlocks() {
        List<Block> blocks = new ArrayList<>();
        return blocks;
    }

}