package by.it_academy.jd2.Mk_JD2_98_23.service;


import by.it_academy.jd2.Mk_JD2_98_23.core.dto.ArtistDTO;
import by.it_academy.jd2.Mk_JD2_98_23.core.dto.GenrDTO;
import by.it_academy.jd2.Mk_JD2_98_23.core.dto.VoteCreateDTO;
import by.it_academy.jd2.Mk_JD2_98_23.core.dto.VoteDTO;
import by.it_academy.jd2.Mk_JD2_98_23.dao.api.IVoteDao;
import by.it_academy.jd2.Mk_JD2_98_23.service.api.IArtistService;
import by.it_academy.jd2.Mk_JD2_98_23.service.api.IGenreService;
import by.it_academy.jd2.Mk_JD2_98_23.service.api.IVoteService;
import by.it_academy.jd2.Mk_JD2_98_23.service.factory.ArtistServiceFactory;
import by.it_academy.jd2.Mk_JD2_98_23.service.factory.GenreServiceFactory;


import java.util.*;
import java.util.stream.Collectors;

public class VoteService implements IVoteService {
    private final IVoteDao voteDao;
    private final IGenreService genreService;
    private final IArtistService artistService;

    public VoteService(IVoteDao voteDao) {
        this.voteDao = voteDao;
        this.artistService = ArtistServiceFactory.getInstance();
        this.genreService = GenreServiceFactory.getInstance();
    }

    @Override
    public List<VoteDTO> get() {
        return new ArrayList<>(voteDao.get());
    }

    @Override
    public VoteDTO get(int id) {
        return voteDao.get(id);
    }

    @Override
    public VoteDTO save(VoteCreateDTO gen) {
        validate(gen);
        return voteDao.save(gen);
    }

    public void validate(VoteCreateDTO vote){
        List<Integer> genre = vote.getGenre();
        if (genre.size()<3 || genre.size()>5){
            throw new IllegalArgumentException("Жанров должно быть от 3 до 5");
        }
        for (Integer genr:genre){
            GenrDTO g = genreService.get(genr);
            if (g == null){
                throw new IllegalArgumentException("Жанра не существует");
            }
        }
    }

    @Override
    public List<ArtistDTO> getTopArtist() {
        List<VoteDTO> votes= voteDao.get();
        Map<Integer,Integer> top = new HashMap<>();
        for (VoteDTO element:votes) {
            if (top.containsKey(element.getArtist())){
                top.put(element.getArtist(),top.get(element.getArtist())+1);
            } else {
                top.put(element.getArtist(),1);
            }
        }
        top = top.entrySet().stream().sorted(Collections.reverseOrder
                (Map.Entry.comparingByValue())).collect(Collectors
                .toMap(Map.Entry::getKey,
                        Map.Entry::getValue,(e1,e2)->e1,LinkedHashMap::new));

        List<ArtistDTO> result =new ArrayList();
        for (Integer id:top.keySet()){
            result.add(artistService.get(id));
        }
        return result;
    }

    @Override
    public List<GenrDTO> getTopGenre() {
        List<VoteDTO> votes= voteDao.get();
        Map<Integer,Integer> top = new HashMap<>();
        for (VoteDTO element:votes) {
            List<Integer> genre = element.getGenre();
            for (Integer id:genre) {
                if (top.containsKey(id)) {
                    top.put(id, top.get(id) + 1);
                } else {
                    top.put(id, 1);
                }
            }
        }
        top = top.entrySet().stream().sorted(Collections.reverseOrder
                (Map.Entry.comparingByValue())).collect(Collectors
                .toMap(Map.Entry::getKey,
                        Map.Entry::getValue,(e1,e2)->e1,LinkedHashMap::new));

        List<GenrDTO> result =new ArrayList();
        for (Integer id:top.keySet()){
            result.add(genreService.get(id));
        }
        return result;
    }

    @Override
    public List<String> getInfoByDate() {
        List<VoteDTO> votes= voteDao.get();
        Map<Date,String> infoMap = new HashMap<>();
        for (VoteDTO element:votes){
            infoMap.put(element.getDate(),element.getInfo());
        }
        return new ArrayList<>(infoMap.values());
    }
    public List<VoteDTO> getSortedTime(){
        List<VoteDTO> votes= voteDao.get();
        Collections.sort(votes,Collections.reverseOrder());
        return votes;
    }
}
