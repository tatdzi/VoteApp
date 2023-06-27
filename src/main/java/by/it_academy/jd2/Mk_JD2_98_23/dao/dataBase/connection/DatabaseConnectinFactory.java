package by.it_academy.jd2.Mk_JD2_98_23.dao.dataBase.connection;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.*;
import java.util.Properties;

public class DatabaseConnectinFactory {
    private static ComboPooledDataSource cpds;

    static {
        cpds = new ComboPooledDataSource();
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Ошибка, драйвер для базы не найден", e);
        }
        cpds.setJdbcUrl("jdbc:postgresql://localhost:5432/votes");
        cpds.setUser( "postgres");
        cpds.setPassword( "postgres");
        cpds.setMaxPoolSize(10);
    }

    public static Connection getDbConnection() throws ClassNotFoundException, SQLException {
        return cpds.getConnection();
    }
}
