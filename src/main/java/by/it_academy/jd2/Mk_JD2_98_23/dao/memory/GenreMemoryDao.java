package by.it_academy.jd2.Mk_JD2_98_23.dao.memory;

/*
public class GenreMemoryDao implements IGenreDao {
    private Map<Integer,GenrDTO> genre = new ConcurrentHashMap<>();


    public GenreMemoryDao() {
        {
            GenrDTO genr = new GenrDTO(genre.size() + 1, "rap");
            genre.put(genr.getId(), genr);
        }
        {
            GenrDTO genr = new GenrDTO(genre.size() + 1, "pop music");
            genre.put(genr.getId(), genr);
        }
        {
            GenrDTO genr = new GenrDTO(genre.size() + 1, "rock music");
            genre.put(genr.getId(), genr);
        }
        {
            GenrDTO genr = new GenrDTO(genre.size() + 1, "opera music");
            genre.put(genr.getId(), genr);
        }
        {
            GenrDTO genr = new GenrDTO(genre.size() + 1, "classical music");
            genre.put(genr.getId(), genr);
        }
        {
            GenrDTO genr = new GenrDTO(genre.size() + 1, "heavy metal");
            genre.put(genr.getId(), genr);
        }
        {
            GenrDTO genr = new GenrDTO(genre.size() + 1, "electronic");
            genre.put(genr.getId(), genr);
        }
        {
            GenrDTO genr = new GenrDTO(genre.size() + 1, "disco");
            genre.put(genr.getId(), genr);
        }
        {
            GenrDTO genr = new GenrDTO(genre.size() + 1, "blues");
            genre.put(genr.getId(), genr);
        }
    }


    @Override
    public List<GenrDTO> get() {
        return new ArrayList<>(genre.values());
    }

    @Override
    public GenrDTO get(int id) {
        return genre.get(id);
    }

    @Override
    public synchronized GenrDTO save(GenreCreateDTO gen) {
        GenrDTO dto = new GenrDTO(genre.size()+1,gen.getName());
        this.genre.put(dto.getId(),dto);
        return dto;
    }
}

 */
