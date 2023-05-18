package by.it_academy.jd2.Mk_JD2_98_23.dao.dataBase;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.ArtistCreateDTO;
import by.it_academy.jd2.Mk_JD2_98_23.core.dto.ArtistDTO;
import by.it_academy.jd2.Mk_JD2_98_23.dao.api.IArtistDao;
import by.it_academy.jd2.Mk_JD2_98_23.dao.factory.ArtistsDataBaseHandlerFactory;

import java.util.List;

public class ArtistDataBaseDao implements IArtistDao {
    ArtistsDatabaseHendler dbHendler;


    public ArtistDataBaseDao() {
        this.dbHendler = ArtistsDataBaseHandlerFactory.getInstance();
    }



    @Override
    public List<ArtistDTO> get() {
        return dbHendler.get();
    }

    @Override
    public ArtistDTO get(int id) {
        return dbHendler.get(id);
    }

    @Override
    public synchronized ArtistDTO save(ArtistCreateDTO gen) {
        dbHendler.save(gen.getName());
        return dbHendler.get(gen.getName());
    }
}
