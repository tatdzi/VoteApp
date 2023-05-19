package by.it_academy.jd2.Mk_JD2_98_23.service.api;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.ArtistDTO;
import by.it_academy.jd2.Mk_JD2_98_23.core.dto.GenrDTO;
import by.it_academy.jd2.Mk_JD2_98_23.core.dto.VoteCreateDTO;
import by.it_academy.jd2.Mk_JD2_98_23.core.dto.VoteDTO;

import java.util.List;

public interface IVoteService extends ICRUDService<VoteDTO, VoteCreateDTO> {
    List<ArtistDTO> getTopArtist();
    List<GenrDTO> getTopGenre();
    List<String> getInfoByDate();
    List<VoteDTO> getSortedTime();
}
