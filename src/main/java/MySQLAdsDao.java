import java.sql.*;
import java.util.List;

public class MySQLAdsDao implements AdsDao {
    private Connection connection;

    public MySQLAdsDao(Config config) {
        try {
            connection = DriverManager.getConnection(
                    Config.getUrl(),  // Changed from Config.getUrl()
                    config.getUsername(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public List<Ad> all() {
        return null;
    }

    @Override
    public Long insert(Ad ad) {
        String query = "INSERT INTO ads(user_id, title, description) VALUES (?, ?, ?)";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());
            stmt.executeUpdate();
            rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getLong(1);
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error inserting a new ad.", e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Ad findAdById(long id) {
        return null;
    }

    @Override
    public void update(Ad ad) {

    }

    @Override
    public void delete(long id) {

    }

}
