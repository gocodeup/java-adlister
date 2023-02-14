package com.codeup.adlister.dao;

import com.codeup.adlister.models.AdCat;

import java.util.List;

public interface Adcats {


    List<AdCat> getRelated(String ad_id);

    Long insert(AdCat adCat);
}
