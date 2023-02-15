package com.codeup.adlister.dao;

import com.codeup.adlister.models.AdCat;
import com.codeup.adlister.models.JoinReturns;

import java.util.List;

public interface Adcats {


    List<JoinReturns> getRelated(String ad_id);

    void insert(AdCat adCat);
}
