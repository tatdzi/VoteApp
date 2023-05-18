package by.it_academy.jd2.Mk_JD2_98_23.dao.factory;

import by.it_academy.jd2.Mk_JD2_98_23.dao.api.IArtistDao;
import by.it_academy.jd2.Mk_JD2_98_23.dao.dataBase.ArtistDataBaseDao;
import by.it_academy.jd2.Mk_JD2_98_23.dao.memory.ArtistMemoryDao;

public class ArtistDaoFactory {
    private static IArtistDao instance;

    private ArtistDaoFactory() {
    }

    public static IArtistDao getInstance(){
        if (instance == null) {
            synchronized (ArtistDaoFactory.class) {
                if (instance == null) {
                    instance = new ArtistDataBaseDao() {
                    };
                }
            }
        }
        return instance;
    }
}
