import java.util.List;

public interface AdsDao {
    List<Ad> all();
    Long insert(Ad ad);
    Ad findAdById(long id);
    void update(Ad ad);
    void delete(long id);
}

