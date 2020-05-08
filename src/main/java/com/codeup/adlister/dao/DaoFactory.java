package com.codeup.adlister.dao;

import com.codeup.adlister.models.Config;

public class DaoFactory {
    private static Ads adsDao;
    private static Users usersDao;
    private static Types typesDao;
    private static AdImages adImagesDao;
    private static Config config = new Config();

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new MySQLAdsDao(config);
        }
        return adsDao;
    }

    public static Users getUsersDao() {
        if (usersDao == null) {
            usersDao = new MySQLUsersDao(config);
        }
        return usersDao;
    }

    public static Types getTypesDao() {
        if (typesDao == null) {
            typesDao = new MySQLTypesDao(config);
        }
        return typesDao;
    }

    public static AdImages getAdImagesDao() {
        if (adImagesDao == null) {
            adImagesDao = new MySQLAdImagesDao(config);
        }
        return adImagesDao;
    }
}
