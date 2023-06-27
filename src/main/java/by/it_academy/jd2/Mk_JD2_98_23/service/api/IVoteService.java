package by.it_academy.jd2.Mk_JD2_98_23.service.api;

import by.it_academy.jd2.Mk_JD2_98_23.core.entity.ArtistEntity;
import by.it_academy.jd2.Mk_JD2_98_23.core.dto.VoteCreateDTO;
import by.it_academy.jd2.Mk_JD2_98_23.core.entity.GenrEntity;
import by.it_academy.jd2.Mk_JD2_98_23.core.entity.VoteEntity;

import java.util.List;

public interface IVoteService extends ICRUDService<VoteEntity, VoteCreateDTO> {
    List<ArtistEntity> getTopArtist();
    List<GenrEntity> getTopGenre();
    List<String> getInfoByDate();
    List<VoteEntity> getSortedTime();
}
