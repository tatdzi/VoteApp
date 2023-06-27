package by.it_academy.jd2.Mk_JD2_98_23.service.springService;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.ArtistCreateDTO;
import by.it_academy.jd2.Mk_JD2_98_23.core.entity.ArtistEntity;
import by.it_academy.jd2.Mk_JD2_98_23.dao.api.IArtistDao;
import by.it_academy.jd2.Mk_JD2_98_23.service.api.IArtistService;

import java.util.List;

public class ArtistService implements IArtistService {
    private final IArtistDao dao;

    public ArtistService(IArtistDao artistDTO) {
        this.dao=artistDTO;
    }

    @Override
    public List<ArtistEntity> get() {
        return dao.get();
    }

    @Override
    public ArtistEntity get(int id) {
        return dao.get(id);
    }

    @Override
    public ArtistEntity save(ArtistCreateDTO gen) {
        ArtistEntity dto = new ArtistEntity(gen.getName());
        return dao.save(dto);
    }
}
