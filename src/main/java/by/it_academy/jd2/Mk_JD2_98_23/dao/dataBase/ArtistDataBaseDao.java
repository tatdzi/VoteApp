package by.it_academy.jd2.Mk_JD2_98_23.dao.dataBase;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.ArtistCreateDTO;
import by.it_academy.jd2.Mk_JD2_98_23.core.dto.ArtistDTO;
import by.it_academy.jd2.Mk_JD2_98_23.dao.api.IArtistDao;
import by.it_academy.jd2.Mk_JD2_98_23.dao.dataBase.connection.Const;
import by.it_academy.jd2.Mk_JD2_98_23.dao.dataBase.connection.DatabaseConnectinFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArtistDataBaseDao extends DatabaseConnectinFactory implements IArtistDao {



    public ArtistDataBaseDao() {
    }

    @Override
    public List<ArtistDTO> get() {
        List<ArtistDTO> artistDTOList = new ArrayList<>();
        String insert = "SELECT artists_id, name FROM "+ Const.ARTISTS_TABLE;
        try (Connection conn = DatabaseConnectinFactory.getDbConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(insert)){
            while (rs.next()){
                artistDTOList.add(new ArtistDTO(rs.getInt("artists_id"),rs.getString("name")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return artistDTOList;
    }

    @Override
    public ArtistDTO get(int id) {
        ArtistDTO dto = null;
        String insert = "SELECT artists_id, name FROM "+Const.ARTISTS_TABLE+" WHERE artists_id = "+id+";";
        try (Connection conn = DatabaseConnectinFactory.getDbConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(insert);){
            while (rs.next()) {
                dto = new ArtistDTO(rs.getInt("artists_id"), rs.getString("name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return dto;
    }

    @Override
    public synchronized ArtistDTO save(ArtistCreateDTO gen) {
        ArtistDTO dto = null;
        String insert = "INSERT INTO "+Const.ARTISTS_TABLE+"(name)  VALUES ('"+gen.getName()+"') RETURNING artists_id";
        try (Connection conn = DatabaseConnectinFactory.getDbConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(insert)){
            if (rs.next()){
                dto=new ArtistDTO(rs.getInt("artists_id"),gen.getName());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return dto;
    }
}
