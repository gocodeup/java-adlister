import com.mysql.cj.jdbc.Driver;

import java.sql.*;


public class jdbcLecture {

    public static void main(String[] args) throws SQLException {
        DriverManager.registerDriver(new Driver());
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/codeup_test_db?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true", "root", "codeup");

//        Statement statement = connection.createStatement();
//
//
//        ResultSet selectResults = statement.executeQuery("SELECT * FROM albums LIMIT 10");

//        while(selectResults.next()) {
//            System.out.println("Here's your album!");
//            System.out.println("record_name : " + selectResults.getString("record_name"));
//            System.out.println("release_date : " + selectResults.getInt("release_date"));
//            System.out.println();
//        }

        // Example: INSERTION of new record + return of ID

        String insertQuery = "INSERT INTO albums (artist_name,record_name, release_date) VALUES ('Mac Miller', 'Circles', 2020)";

        Statement insertStatement = connection.createStatement();

        insertStatement.executeUpdate(insertQuery, Statement.RETURN_GENERATED_KEYS);
        ResultSet insertResults = insertStatement.getGeneratedKeys();

        if (insertResults.next()) {
            System.out.println("Administrator: A new item has been created with the id of : " + insertResults.getLong(1));
        }
    }


}

