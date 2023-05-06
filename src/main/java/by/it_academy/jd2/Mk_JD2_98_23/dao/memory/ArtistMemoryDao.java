package by.it_academy.jd2.Mk_JD2_98_23.dao.memory;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.ArtistCreateDTO;
import by.it_academy.jd2.Mk_JD2_98_23.core.dto.ArtistDTO;
import by.it_academy.jd2.Mk_JD2_98_23.dao.api.IArtistDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ArtistMemoryDao implements IArtistDao {
    private Map<Integer,ArtistDTO> artists= new ConcurrentHashMap<>();


    public ArtistMemoryDao() {
        ArtistDTO artist =new ArtistDTO(artists.size()+1,"Rosalía");
        artists.put(artist.getId(),artist);
        artist =new ArtistDTO(artists.size()+1,"Glenn Danzig");
        artists.put(artist.getId(),artist);
        artist =new ArtistDTO(artists.size()+1,"Billie Eilish");
        artists.put(artist.getId(),artist);
        artist =new ArtistDTO(artists.size()+1,"Burna Boy");
        artists.put(artist.getId(),artist);
    }



    @Override
    public List<ArtistDTO> get() {
        return new ArrayList<>(artists.values());
    }

    @Override
    public ArtistDTO get(int id) {
        return artists.get(id);
    }

    @Override
    public synchronized ArtistDTO save(ArtistCreateDTO gen) {
        ArtistDTO dto = new ArtistDTO(artists.size()+1, gen.getName());
            this.artists.put(dto.getId(),dto);

        return dto;
    }
}
