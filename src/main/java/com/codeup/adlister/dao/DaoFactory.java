package com.codeup.adlister.dao;


public class DaoFactory {
    private static Ads adsDao;
    private static Users usersDao;
    private static Categories categoriesDao;
    private static Adcats adCatsDao;
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

    public static Categories getCategoryDao() {
        if (categoriesDao == null) {
            categoriesDao = new MySQLCategoryDao(config);
        }
        return categoriesDao;
    }

    public static Adcats getAdCatsDao() {
        if (adCatsDao == null) {
            adCatsDao = new MySQLAdCatDao(config);
        }
        return adCatsDao;
    }
}
