package com.codeup.adlister.dao;

import com.codeup.adlister.models.AdImage;

public interface AdImages {
    // list all images
    AdImage getImageURLByAdId(Long id);
}
