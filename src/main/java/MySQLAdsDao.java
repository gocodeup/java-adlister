import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads{
    Config config = new Config();
    Connection connection;


    public MySQLAdsDao() throws SQLException {
        Config config = new Config();
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public List<Ad> all() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM ads");
            return productFromResults(resultSet);
        } catch (SQLException e ) {
            throw new RuntimeException("Sorry! There was an error getting all ads ", e);
        }
    }

    @Override
    public void insert(Ad ad) {

    }

    private Ad takeAd(ResultSet resultSet) throws SQLException {
        return new Ad (
                resultSet.getInt("id"),
                resultSet.getInt("user_id"),
                resultSet.getString("title"),
                resultSet.getString("description")
        );
    }

    private List<Ad> productFromResults(ResultSet resultSet) throws SQLException {
        List<Ad> products = new ArrayList<>();

        while (resultSet.next()) {
            products.add(takeAd(resultSet));
        }
        return products;
    }


    public void insertAd(Ad ad) {
        try {
            Statement statement = connection.createStatement();
            String query = "INSERT INTO ads(title,description) VALUES (" + "'" + ad.getTitle() + "'" + "," + ad.getDescription() + "'" + ")";
            System.out.println(query);
            statement.executeUpdate(query,Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();
            System.out.println("Created new ad with an ID of: " + resultSet.getLong(1));

        } catch (SQLException e) {
            throw new RuntimeException("There was an error creating the new ad!", e);
        }
    }



    public static void main(String[] args) {

    }
}
