package by.it_academy.jd2.Mk_JD2_98_23.service;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.GenreCreateDTO;
import by.it_academy.jd2.Mk_JD2_98_23.core.entity.GenrEntity;
import by.it_academy.jd2.Mk_JD2_98_23.dao.api.IGenreDao;
import by.it_academy.jd2.Mk_JD2_98_23.service.api.IGenreService;

import java.util.List;

public class GenreService implements IGenreService {

    private final IGenreDao dao;

    public GenreService(IGenreDao genreDao) {
        dao = genreDao;
    }

    @Override
    public List<GenrEntity> get() {
        return dao.get();
    }

    @Override
    public GenrEntity get(int id) {
        return dao.get(id);
    }

    @Override
    public GenrEntity save(GenreCreateDTO gen) {
        GenrEntity dto = new GenrEntity(gen.getName());
        return dao.save(dto);
    }
}
