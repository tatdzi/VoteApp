package by.it_academy.jd2.Mk_JD2_98_23.dao.factory;

import by.it_academy.jd2.Mk_JD2_98_23.dao.dataBase.connection.DatabaseConnectin;

public class DataBaseConnectionFactory {
    private static DatabaseConnectin instance;

    private DataBaseConnectionFactory() {
    }

    public static DatabaseConnectin getInstance(){
        if (instance == null) {
            synchronized (DataBaseConnectionFactory.class) {
                if (instance == null) {
                    instance = new DatabaseConnectin() {
                    };
                }
            }
        }
        return instance;
    }
}
