package by.it_academy.jd2.Mk_JD2_98_23.dao.dataBase;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.GenrDTO;
import by.it_academy.jd2.Mk_JD2_98_23.core.dto.GenreCreateDTO;
import by.it_academy.jd2.Mk_JD2_98_23.dao.api.IGenreDao;
import by.it_academy.jd2.Mk_JD2_98_23.dao.factory.GenreDataBaseHandlerFactory;

import java.util.List;

public class GenreDataBaseDao implements IGenreDao {
    GenreDatabaseHendler dbHendler;


    public GenreDataBaseDao() {
        this.dbHendler = GenreDataBaseHandlerFactory.getInstance();
    }



    @Override
    public List<GenrDTO> get() {
        return dbHendler.get();
    }

    @Override
    public GenrDTO get(int id) {
        return dbHendler.get(id);
    }

    @Override
    public synchronized GenrDTO save(GenreCreateDTO gen) {
        dbHendler.save(gen.getName());
        return dbHendler.get(gen.getName());
    }
}
