package by.it_academy.jd2.Mk_JD2_98_23.core.dto;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class VoteDTO implements Comparable<VoteDTO> {
    private Integer id;
    private Integer artist;
    private Integer[] genre;
    private String info;

    private Date date = new Date();


    public VoteDTO(Integer id, Integer artist, Integer[] genre, String info) {
        this.id = id;
        this.artist = artist;
        this.genre = genre;
        this.info = info;
    }

    public Integer getId() {
        return id;
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

    public Date getDate() {
        return date;
    }

    @Override
    public int compareTo(VoteDTO o) {
        return getDate().compareTo(o.getDate());
    }
}
