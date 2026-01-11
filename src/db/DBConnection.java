package db;

import java.sql.Connection;
import java.sql.DriverManager;
import config.DBConfig;

public class DBConnection {
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    DBConfig.URL,
                    DBConfig.USER,
                    DBConfig.PASSWORD
            );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
