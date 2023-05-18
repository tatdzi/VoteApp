package by.it_academy.jd2.Mk_JD2_98_23.dao.factory;

import by.it_academy.jd2.Mk_JD2_98_23.dao.dataBase.ArtistsDatabaseHendler;
import by.it_academy.jd2.Mk_JD2_98_23.dao.dataBase.GenreDatabaseHendler;

public class GenreDataBaseHandlerFactory {
    private static GenreDatabaseHendler instance;

    private GenreDataBaseHandlerFactory() {
    }

    public static GenreDatabaseHendler getInstance(){
        if (instance == null) {
            synchronized (GenreDataBaseHandlerFactory.class) {
                if (instance == null) {
                    instance = new GenreDatabaseHendler() {
                    };
                }
            }
        }
        return instance;
    }
}
