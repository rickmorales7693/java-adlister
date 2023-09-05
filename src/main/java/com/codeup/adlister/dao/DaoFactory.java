package com.codeup.adlister.dao;

import Utils.Config;
import com.codeup.adlister.models.User;

import java.sql.SQLException;

public class DaoFactory {
    private static Ads adsDao;
    private static Users usersDao;
    private static Config config = new Config();

    public static Ads getAdsDao() throws SQLException {
        if (adsDao == null) {
            adsDao = new MySQLAdsDao(config);
        }
        return adsDao;
    }

    public static Users getUsersDao() throws SQLException {  // Add this method
        if (usersDao == null) {
            usersDao = new MySQLUsersDao(config) {
                @Override
                public User findByUsername(String username) {
                    return null;
                }

                @Override
                public Long insert(User user) {
                    return null;
                }
            };
        }
        return usersDao;
    }

}
