package by.it_academy.jd2.Mk_JD2_98_23.dao.factory;

import by.it_academy.jd2.Mk_JD2_98_23.dao.dataBase.ArtistsDatabaseHendler;

public class ArtistsDataBaseHandlerFactory {
    private static ArtistsDatabaseHendler instance;

    private ArtistsDataBaseHandlerFactory() {
    }

    public static ArtistsDatabaseHendler getInstance(){
        if (instance == null) {
            synchronized (ArtistsDataBaseHandlerFactory.class) {
                if (instance == null) {
                    instance = new ArtistsDatabaseHendler() {
                    };
                }
            }
        }
        return instance;
    }
}
