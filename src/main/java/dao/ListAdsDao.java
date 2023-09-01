//package dao;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ListAdsDao<Ad> implements Ads {
//    private List<Ad> ads;
//
//    public List<Ad> all() {
//        if (ads == null) {
//            ads = generateAds();
//        }
//        return ads;
//    }
//
//    @Override
//    public Long insert(models.Ad ad) {
//        return null;
//    }
//
//    public Long insert(Ad ad) {
//        // make sure we have ads
//        if (ads == null) {
//            ads = generateAds();
//        }
//        long newId = ads.size() + 1;
//        ad.setId((long) ads.size());
//        ads.add(ad);
//        return ad.getId();
//    }
//
//    @Override
//    public Long insert(Object o) {
//        return null;
//    }
//
//    @Override
//    public Ad findAdById(long id) {
//        return null;
//    }
//
//    @Override
//    public void update(Object o) {
//
//    }
//
//    @Override
//    public void update(Ad ad) {
//
//    }
//
//    @Override
//    public void delete(long id) {
//
//    }
//
//    private List<Ad> generateAds() {
//        List<Ad> ads = new ArrayList<>();
//        ads.add(new Ad(
//            1,
//            1,
//            "playstation for sale",
//            "This is a slightly used playstation"
//        ));
//        ads.add(new Ad(
//            2,
//            1,
//            "Super Nintendo",
//            "Get your game on with this old-school classic!"
//        ));
//        ads.add(new Ad(
//            3,
//            2,
//            "Junior Java Developer Position",
//            "Minimum 7 years of experience required. You will be working in the scripting language for Java, JavaScript"
//        ));
//        ads.add(new Ad(
//            4,
//            2,
//            "JavaScript Developer needed",
//            "Must have strong Java skills"
//        ));
//        return ads;
//    }
//}
