package by.it_academy.jd2.Mk_JD2_98_23.dao.dataBase;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.ArtistCreateDTO;
import by.it_academy.jd2.Mk_JD2_98_23.core.dto.ArtistDTO;
import by.it_academy.jd2.Mk_JD2_98_23.dao.api.IArtistDao;
import by.it_academy.jd2.Mk_JD2_98_23.dao.dataBase.connection.Const;
import by.it_academy.jd2.Mk_JD2_98_23.dao.dataBase.connection.DatabaseConnectin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArtistDataBaseDao extends DatabaseConnectin implements IArtistDao {



    public ArtistDataBaseDao() {
    }



    @Override
    public List<ArtistDTO> get() {
        List<ArtistDTO> artistDTOList = new ArrayList<>();
        String insert = "SELECT id, name FROM "+ Const.ARTISTS_TABLE;
        try {
            PreparedStatement ps = getDbConnection().prepareStatement(insert);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                artistDTOList.add(new ArtistDTO(rs.getInt("id"),rs.getString("name")));
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
        String insert = "SELECT id, name FROM "+Const.ARTISTS_TABLE+" WHERE id = "+id;
        try {
            PreparedStatement ps = getDbConnection().prepareStatement(insert);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                dto = new ArtistDTO(rs.getInt("id"), rs.getString("name"));
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
        String insert = "INSERT INTO "+Const.ARTISTS_TABLE+"(name)  VALUES (?)";
        try {
            PreparedStatement ps = getDbConnection().prepareStatement(insert);
            ps.setString(1,gen.getName());
            ps.executeUpdate();
            insert = "SELECT id, name FROM "+ Const.ARTISTS_TABLE+" WHERE name = "+gen.getName();
            ps = getDbConnection().prepareStatement(insert);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                dto = new ArtistDTO(rs.getInt("id"), rs.getString("name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return dto;
    }
}
