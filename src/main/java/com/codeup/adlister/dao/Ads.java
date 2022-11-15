package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();
    // insert a new ad and return the new ad's id
    Long insert(Ad ad);

<<<<<<< HEAD
    void update(Ad ad,String title,String description);
=======
   void update(Ad ad,String title,String description);
>>>>>>> fe7c836abce2643dcc2c5cd3a0d83e995b916298

    void delete(Ad ad);

    Ad findAd(long userId, String title);

    List<Ad> searchAD(String tittle);
<<<<<<< HEAD
}
=======
}
>>>>>>> fe7c836abce2643dcc2c5cd3a0d83e995b916298
