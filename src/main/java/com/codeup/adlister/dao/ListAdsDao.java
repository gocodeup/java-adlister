package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.util.ArrayList;
import java.util.List;

public class ListAdsDao implements Ads {
    private List<Ad> ads;

    public List<Ad> all() {
        if (ads == null) {
            ads = generateAds();
        }
        return ads;
    }

    public Long insert(Ad ad) {
        // make sure we have ads
        if (ads == null) {
            ads = generateAds();
        }
        // we'll assign an "id" here based on the size of the ads list
        // really the dao would handle this
<<<<<<< HEAD
        ad.setId(ads.size());
=======
        ad.setId((long) ads.size());
>>>>>>> e076e545f3f9fe01d71185c5a383495f8ede8a36
        ads.add(ad);
        return ad.getId();
    }

<<<<<<< HEAD
    @Override
    public List<Ad> userAds(Long user_id) {
        return null;
    }

    private List<Ad> generateAds() {
        List<Ad> ads = new ArrayList<>();
        ads.add(new Ad(
            1,
            1,
            "playstation for sale",
            "This is a slightly used playstation"
        ));
        ads.add(new Ad(
            2,
            1,
            "Super Nintendo",
            "Get your game on with this old-school classic!"
        ));
        ads.add(new Ad(
            3,
            2,
            "Junior Java Developer Position",
            "Minimum 7 years of experience required. You will be working in the scripting language for Java, JavaScript"
        ));
        ads.add(new Ad(
            4,
            2,
            "JavaScript Developer needed",
            "Must have strong Java skills"
        ));
        return ads;
    }
}
=======
    private List<Ad> generateAds() {
        List<Ad> ads = new ArrayList<>();
        return ads;
    }
}

>>>>>>> e076e545f3f9fe01d71185c5a383495f8ede8a36
