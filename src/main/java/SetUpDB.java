import java.io.*;
import java.nio.file.*;
import java.sql.*;
import java.util.*;

public class SetUpDB {
    public static Connection getConnection() throws IOException, SQLException {
        Properties properties = new Properties();
        try (InputStream inputStream = Files.newInputStream(Paths.get("db.properties"))
        ){
            properties.load(inputStream);
        }
        String drivers = properties.getProperty("jdbc.drivers");
        if (drivers != null) {
            System.setProperty("jdbc.drivers", drivers);
        }
        String url = properties.getProperty("jdbc.url");
        String username = properties.getProperty("jdbc.username");
        String password = properties.getProperty("jdbc.password");

        return DriverManager.getConnection(url, username, password);
    }
}
