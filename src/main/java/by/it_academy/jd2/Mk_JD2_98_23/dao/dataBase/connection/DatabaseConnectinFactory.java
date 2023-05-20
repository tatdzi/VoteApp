package by.it_academy.jd2.Mk_JD2_98_23.dao.dataBase.connection;

import java.sql.*;
import java.util.Properties;

public class DatabaseConnectinFactory {

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Ошибка, драйвер для базы не найден", e);
        }
    }

    public static Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:postgresql://localhost:5432/votes";
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "postgres");
        Connection dbConnection = DriverManager.getConnection(url,props);
        return dbConnection;
    }
}
