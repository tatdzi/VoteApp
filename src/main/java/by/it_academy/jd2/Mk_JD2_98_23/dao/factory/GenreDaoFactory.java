package by.it_academy.jd2.Mk_JD2_98_23.dao.factory;


import by.it_academy.jd2.Mk_JD2_98_23.dao.api.IGenreDao;
import by.it_academy.jd2.Mk_JD2_98_23.dao.hibernate.GenreHibernateDao;


public class GenreDaoFactory {
    private static IGenreDao instance;

    private GenreDaoFactory() {
    }

    public static IGenreDao getInstance(){
        if (instance == null) {
            synchronized (GenreDaoFactory.class) {
                if (instance == null) {
                    instance = new GenreHibernateDao();
                }
            }
        }
        return instance;
    }
}
