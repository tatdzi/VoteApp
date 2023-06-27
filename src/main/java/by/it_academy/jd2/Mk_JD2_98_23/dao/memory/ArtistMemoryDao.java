package by.it_academy.jd2.Mk_JD2_98_23.dao.memory;

/*
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

 */
