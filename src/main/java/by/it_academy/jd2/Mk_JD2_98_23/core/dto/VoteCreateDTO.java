package by.it_academy.jd2.Mk_JD2_98_23.core.dto;

public class VoteCreateDTO {
    private Integer artist;
    private Integer[] genre;
    private String info;

    public VoteCreateDTO(Integer artist, Integer[] genre, String info) {
        this.artist = artist;
        this.genre = genre;
        this.info = info;
    }

    public Integer getArtist() {
        return artist;
    }

    public Integer[] getGenre() {
        return genre;
    }

    public String getInfo() {
        return info;
    }
}
