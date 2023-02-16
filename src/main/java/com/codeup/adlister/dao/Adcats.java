package com.codeup.adlister.dao;

import com.codeup.adlister.models.AdCat;
import com.codeup.adlister.models.JoinReturns;

import java.util.List;

public interface Adcats {


    void deleteAdCat(String id);

    List<JoinReturns> getRelated(String ad_id);

//    List<AdCat> getRelatedAdCat(String ad_id);

    List<AdCat> getRelatedAdCat(String ad_id);

    void insert(AdCat adCat);
}
