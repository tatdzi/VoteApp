package by.it_academy.jd2.Mk_JD2_98_23.service;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.ArtistCreateDTO;
import by.it_academy.jd2.Mk_JD2_98_23.core.dto.ArtistDTO;
import by.it_academy.jd2.Mk_JD2_98_23.dao.api.IArtistDao;

import by.it_academy.jd2.Mk_JD2_98_23.service.api.IArtistService;

import java.util.List;

public class ArtistService implements IArtistService {
    private final IArtistDao dao;

    public ArtistService(IArtistDao artistDTO) {
        this.dao=artistDTO;
    }

    @Override
    public List<ArtistDTO> get() {
        return dao.get();
    }

    @Override
    public ArtistDTO get(int id) {
        return dao.get(id);
    }

    @Override
    public ArtistDTO save(ArtistCreateDTO gen) {
        return dao.save(gen);
    }
}
