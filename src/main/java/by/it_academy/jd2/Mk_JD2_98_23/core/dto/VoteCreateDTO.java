package by.it_academy.jd2.Mk_JD2_98_23.core.dto;

import java.util.List;

public class VoteCreateDTO {
    private Integer artist;
    private List<Integer> genre;
    private String info;

    public VoteCreateDTO(Integer artist, List<Integer> genre, String info) {
        this.artist = artist;
        this.genre = genre;
        this.info = info;
    }

    public Integer getArtist() {
        return artist;
    }

    public List<Integer> getGenre() {
        return genre;
    }

    public String getInfo() {
        return info;
    }
}
