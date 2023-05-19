package by.it_academy.jd2.Mk_JD2_98_23.dao.dataBase.connection;

import java.sql.*;

public class DatabaseConnectin extends Configs {
    Connection dbConnection;
    protected Connection getDbConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String url ="jdbc:postgresql://"+dbHost+dbPort+dbName;
        dbConnection = DriverManager.getConnection(url, dbUser,dbPass);
        return dbConnection;
    }
}
