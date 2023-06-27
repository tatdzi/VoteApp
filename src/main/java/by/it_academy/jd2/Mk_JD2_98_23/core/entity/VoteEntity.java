package by.it_academy.jd2.Mk_JD2_98_23.core.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
@Entity
@Table(name = "votes")
public class VoteEntity implements Comparable<VoteEntity>{
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "votes_id")
    private Integer id;

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinTable(name = "votes_artists",
    joinColumns = @JoinColumn(name = "votes_id"),
    inverseJoinColumns = @JoinColumn(name = "artists_id"))
    private ArtistEntity artist;
    @OneToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinTable(name = "votes_genre",
            joinColumns = @JoinColumn(name = "votes_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<GenrEntity> genre;
    private String info;

    private LocalDateTime date = LocalDateTime.now();


    public VoteEntity() {
    }

    public VoteEntity(ArtistEntity artist, List<GenrEntity> genre, String info) {
        this.artist = artist;
        this.genre = genre;
        this.info = info;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setArtist(ArtistEntity artist) {
        this.artist = artist;
    }

    public void setGenre(List<GenrEntity> genre) {
        this.genre = genre;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public ArtistEntity getArtist() {
        return artist;
    }

    public List<GenrEntity> getGenre() {
        return genre;
    }

    public String getInfo() {
        return info;
    }
    public LocalDateTime getDate() {
        return date;
    }



    @Override
    public int compareTo(VoteEntity o) {
        return getDate().compareTo(o.getDate());
    }
}
