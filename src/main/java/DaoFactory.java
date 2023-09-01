public class DaoFactory {
    private static Ads adsDao;
    private static Config config = new Config();

    public static AdsDao getAdsDao() {
        if (adsDao == null) {
            adsDao = (Ads) new MySQLAdsDao(config);
        }
        return (AdsDao) adsDao;
    }


}
