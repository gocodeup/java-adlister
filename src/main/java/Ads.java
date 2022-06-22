import java.util.List;

public interface Ads {
    List<Ad> all();
    Long insert(Ad ad);
}
