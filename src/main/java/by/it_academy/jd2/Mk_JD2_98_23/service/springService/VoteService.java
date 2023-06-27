package by.it_academy.jd2.Mk_JD2_98_23.service.springService;


import by.it_academy.jd2.Mk_JD2_98_23.core.dto.VoteCreateDTO;
import by.it_academy.jd2.Mk_JD2_98_23.core.entity.ArtistEntity;
import by.it_academy.jd2.Mk_JD2_98_23.core.entity.GenrEntity;
import by.it_academy.jd2.Mk_JD2_98_23.core.entity.VoteEntity;
import by.it_academy.jd2.Mk_JD2_98_23.dao.api.IVoteDao;
import by.it_academy.jd2.Mk_JD2_98_23.service.api.IArtistService;
import by.it_academy.jd2.Mk_JD2_98_23.service.api.IGenreService;
import by.it_academy.jd2.Mk_JD2_98_23.service.api.IVoteService;
import by.it_academy.jd2.Mk_JD2_98_23.service.factory.ArtistServiceFactory;
import by.it_academy.jd2.Mk_JD2_98_23.service.factory.GenreServiceFactory;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class VoteService implements IVoteService {
    private final IVoteDao voteDao;
    private final IGenreService genreService;
    private final IArtistService artistService;

    public VoteService(IVoteDao voteDao,IGenreService genreService,IArtistService artistService) {
        this.voteDao = voteDao;
        this.artistService = artistService;
        this.genreService = genreService;
    }

    @Override
    public List<VoteEntity> get() {
        return new ArrayList<>(voteDao.get());
    }

    @Override
    public VoteEntity get(int id) {
        return voteDao.get(id);
    }

    @Override
    public VoteEntity save(VoteCreateDTO gen) {
        validate(gen);
        ArtistEntity artist = artistService.get(gen.getArtist());
        List<GenrEntity> genrDTOList = new ArrayList<>();
        for (Integer id:gen.getGenre()){
            genrDTOList.add(genreService.get(id));
        }
        VoteEntity dto = new VoteEntity(artist,genrDTOList,gen.getInfo());
        return voteDao.save(dto);
    }

    public void validate(VoteCreateDTO vote){
        List<Integer> genre = vote.getGenre();
        if (genre.size()<3 || genre.size()>5){
            throw new IllegalArgumentException("Жанров должно быть от 3 до 5");
        }
        for (Integer genr:genre){
            GenrEntity g = genreService.get(genr);
            if (g == null){
                throw new IllegalArgumentException("Жанра не существует");
            }
        }
    }

    @Override
    public List<ArtistEntity> getTopArtist() {
        List<VoteEntity> votes= voteDao.get();
        Map<ArtistEntity,Integer> top = new HashMap<>();
        for (VoteEntity element:votes) {
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

        List<ArtistEntity> result =new ArrayList(top.keySet());
        for (ArtistEntity id:top.keySet()){
           // result.add(artistService.get(id));
        }
        return result;
    }

    @Override
    public List<GenrEntity> getTopGenre() {
        List<VoteEntity> votes= voteDao.get();
        Map<GenrEntity,Integer> top = new HashMap<>();
        for (VoteEntity element:votes) {
            List<GenrEntity> genre = element.getGenre();
            for (GenrEntity id:genre) {
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

        List<GenrEntity> result =new ArrayList(top.keySet());
        for (GenrEntity id:top.keySet()){
           // result.add(genreService.get(id));
        }
        return result;
    }

    @Override
    public List<String> getInfoByDate() {
        List<VoteEntity> votes= voteDao.get();
        Map<LocalDateTime,String> infoMap = new HashMap<>();
        for (VoteEntity element:votes){
           infoMap.put(element.getDate(),element.getInfo());
        }
        return new ArrayList<>(infoMap.values());
    }
    public List<VoteEntity> getSortedTime(){
        List<VoteEntity> votes= voteDao.get();
        Collections.sort(votes,Collections.reverseOrder());
        return votes;
    }
}
