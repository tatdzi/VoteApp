package by.it_academy.jd2.Mk_JD2_98_23.dao.factory;


import by.it_academy.jd2.Mk_JD2_98_23.dao.api.IGenreDao;
import by.it_academy.jd2.Mk_JD2_98_23.dao.dataBase.GenreDataBaseDao;
import by.it_academy.jd2.Mk_JD2_98_23.dao.memory.GenreMemoryDao;

public class GenreDaoFactory {
    private static IGenreDao instance;

    private GenreDaoFactory() {
    }

    public static IGenreDao getInstance(){
        if (instance == null) {
            synchronized (GenreDaoFactory.class) {
                if (instance == null) {
                    instance = new GenreDataBaseDao();
                }
            }
        }
        return instance;
    }
}
