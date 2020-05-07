package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.AdImage;

import java.util.List;

public interface AdImages {
    List<AdImage> getImagesByAdId(long adId);
    Long insert(AdImage adImg);
//    Long attachImageToAd(AdImage img, Ad parent);
}
