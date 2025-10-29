package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
    private static final String DB_URL = System.getenv("DB_URL");

    private static final String DB_USER = System.getenv("DB_USER");
    private static final String DB_PWD = System.getenv("DB_PWD");
    private static final String DB_NAME = System.getenv("DB_NAME");

    static {
        try(
                Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
                Statement statement = conn.createStatement()){
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS " + DB_NAME);
            System.out.printf("Database %s ready to use%n", DB_NAME);

        } catch (SQLException e){
            System.out.println("Couldn't create database:" + e.getMessage());
        }
    }

    public static Connection getConnection() throws SQLException {
        String url_db = DB_URL+DB_NAME;
        return DriverManager.getConnection(url_db,DB_USER, DB_PWD);
    }
}
