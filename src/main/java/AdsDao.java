import java.sql.Connection;

public class AdsDao extends ListAdsDao {

    private static Connection connection;

    public static void main(String[] args) {
        AdsDao adsDao = new AdsDao(connection);
        System.out.println(adsDao.all());
    }

    public AdsDao(Connection connection) {
        super();
        this.connection = connection;
    }

}
