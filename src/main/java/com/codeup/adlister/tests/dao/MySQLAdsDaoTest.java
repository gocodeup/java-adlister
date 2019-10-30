package com.codeup.adlister.tests.dao;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MySQLAdsDaoTest {

    @Test
    void all() {
        assertNotNull(DaoFactory.getAdsDao().all());
    }

    @Test
    void insert() {
        DaoFactory.getAdsDao().insert(new Ad(1L, 1L, "test Ad inserted", "description for test ad", "junitTests"));
        int lastAdInserted = DaoFactory.getAdsDao().all().size();
        assertEquals("test Ad inserted", DaoFactory.getAdsDao().all().get(lastAdInserted - 1).getTitle());
        DaoFactory.getAdsDao().delete(lastAdInserted);
    }

    @Test
    void findAdById() {
        DaoFactory.getAdsDao().insert(new Ad(20L, 1L, "test Ad inserted", "description for test ad", "junitTests"));
        int lastAdInserted = DaoFactory.getAdsDao().all().size();
        assertEquals("test Ad inserted", DaoFactory.getAdsDao().findAdById(20L).getTitle());
        DaoFactory.getAdsDao().delete(lastAdInserted);
    }

    @Test
    void adsTitleQuery() {
        DaoFactory.getAdsDao().insert(new Ad(1L, 1L, "test Ad inserted", "description for test ad", "junitTests"));
        int lastAdInserted = DaoFactory.getAdsDao().all().size();
        assertEquals("test Ad inserted", DaoFactory.getAdsDao().adsTitleQuery("test Ad inserted"));
        DaoFactory.getAdsDao().delete(lastAdInserted);
    }

    @Test
    void delete() {
        DaoFactory.getAdsDao().insert(new Ad(100L, 1L, "CookieCookieCookie", "description for test ad", "junitTests"));
        int lastAdInserted = DaoFactory.getAdsDao().all().size() - 1;

        DaoFactory.getAdsDao().delete(lastAdInserted);

        assertNull(DaoFactory.getAdsDao().findAdById(100L));
    }
}