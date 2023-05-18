package by.it_academy.jd2.Mk_JD2_98_23.dao.dataBase;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.VoteCreateDTO;
import by.it_academy.jd2.Mk_JD2_98_23.core.dto.VoteDTO;
import by.it_academy.jd2.Mk_JD2_98_23.dao.api.IVoteDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VoteDataBaseDao implements IVoteDao {

    private Map<Integer,VoteDTO> votes = new ConcurrentHashMap<>();

    public VoteDataBaseDao() {

    }

    @Override
    public List<VoteDTO> get() {
        return new ArrayList<>(votes.values());
    }

    @Override
    public VoteDTO get(int id) {
        return votes.get(id);
    }

    @Override
    public VoteDTO save(VoteCreateDTO gen) {
        VoteDTO dto = new VoteDTO(votes.size()+1,gen.getArtist(),gen.getGenre(),gen.getInfo());
        this.votes.put(dto.getId(),dto);
        return dto;
    }
}
