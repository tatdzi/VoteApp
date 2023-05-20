package by.it_academy.jd2.Mk_JD2_98_23.dao.dataBase;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.*;
import by.it_academy.jd2.Mk_JD2_98_23.dao.api.IVoteDao;
import by.it_academy.jd2.Mk_JD2_98_23.dao.dataBase.connection.Const;
import by.it_academy.jd2.Mk_JD2_98_23.dao.dataBase.connection.DatabaseConnectinFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VoteDataBaseDao implements IVoteDao {


    public VoteDataBaseDao() {

    }

    @Override
    public List<VoteDTO> get() {
        List<VoteDTO> voteDTOList = new ArrayList<>();
        String insert = "SELECT votes_id,app.artists.artists_id AS artists_id," +
                " app.genre.genre_id AS genre_id, info FROM app.votes " +
                "JOIN app.votes_artists USING (votes_id) " +
                "JOIN app.votes_genre USING (votes_id) " +
                "JOIN app.artists USING (artists_id) " +
                "JOIN app.genre USING (genre_id);";
        try (Connection conn = DatabaseConnectinFactory.getDbConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(insert);){
            Integer id = null;
            Integer atrist = null;
            List<Integer> genre = new ArrayList<>();
            String info = null;
            while (rs.next()){
                Integer new_id = rs.getInt("votes_id");
                if (new_id != id){
                    if (id != null) {
                        voteDTOList.add(new VoteDTO(id, atrist, genre, info));
                    }
                    id = new_id;
                    genre = new ArrayList<>();
                    atrist = rs.getInt("artists_id");
                    info = rs.getString("info");
                    genre.add(rs.getInt("genre_id"));
                }else {
                    genre.add(rs.getInt("genre_id"));
                }
            }
            voteDTOList.add(new VoteDTO(id,atrist,genre,info));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return voteDTOList;
    }

    @Override
    public VoteDTO get(int id) {
        VoteDTO voteDTO= null;
        String insert = "SELECT votes_id,app.artists." +
                "artists_id AS artist_id,\n" +
                "app.genre.genre_id AS genre_id, info" +
                "FROM app.votes " +
                "JOIN app.votes_artists USING (votes_id) " +
                "JOIN app.votes_genre USING (votes_id) " +
                "JOIN app.artists USING (artists_id) " +
                "JOIN app.genre USING (genre_id) WHERE votes_id = "+id+";";
        try (Connection conn = DatabaseConnectinFactory.getDbConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(insert);){
            Integer idDate = null;
            Integer atrist = null;
            List<Integer> genre = new ArrayList<>();
            String info = null;
            while (rs.next()){
                if (idDate !=null ){
                    idDate = rs.getInt("votes_id");
                }
                if (atrist != null) {
                    atrist = rs.getInt("artists_id");
                }
                if (info != null){
                    info = rs.getString("info");
                    }
                genre.add(rs.getInt("genre_id"));
            }
            voteDTO = new VoteDTO(idDate,atrist,genre,info);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return voteDTO;
    }

    @Override
    public VoteDTO save(VoteCreateDTO gen) {
        Integer vote_id = null;
        String insert = "INSERT INTO "+ Const.VOTES_TABLE+"("+Const.VOTES_INFO+
                ")  VALUES ('"+gen.getInfo()+"') RETURNING votes_id";
        try (Connection conn = DatabaseConnectinFactory.getDbConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(insert)){
            if (rs.next()) {
                vote_id = rs.getInt(Const.VOTES_ID);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        saveArtist(vote_id,gen);
        saveGenre(vote_id,gen);
        VoteDTO dto = new VoteDTO(vote_id,gen.getArtist(),gen.getGenre(),gen.getInfo());
        return dto ;
    }

    public void saveArtist(Integer vote_id,VoteCreateDTO gen) {
        ArtistDTO dto = null;
        String insert = "INSERT INTO "+ Const.VOTES_ARTISTS_TABLE+"("+Const.VOTES_ID+", "+Const.ARTISTS_ID+ ")  VALUES ( (SELECT votes_id FROM app.votes WHERE votes_id ="+vote_id+"), (SELECT artists_id FROM app.artists WHERE artists_id =  "+gen.getArtist()+")) RETURNING artists_id";
        try (Connection conn = DatabaseConnectinFactory.getDbConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(insert)){
            if (rs.next()){
                String artist = rs.getString("artists_id");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void saveGenre(Integer vote_id,VoteCreateDTO gen) {
        ArtistDTO dto = null;
        for (Integer genre_id : gen.getGenre()) {
            String insert = "INSERT INTO " + Const.VOTES_GENRE_TABLE + "(" + Const.VOTES_ID + ", " + Const.GENRE_ID + ")  VALUES (" + vote_id + ", " + genre_id + ") RETURNING genre_id";
            try (Connection conn = DatabaseConnectinFactory.getDbConnection();
                 Statement st = conn.createStatement();
                 ResultSet rs = st.executeQuery(insert)) {
                if (rs.next()) {
                    String genr = rs.getString("genre_id");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
