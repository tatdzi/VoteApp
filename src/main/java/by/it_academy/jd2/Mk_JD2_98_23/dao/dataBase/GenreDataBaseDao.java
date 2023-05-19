package by.it_academy.jd2.Mk_JD2_98_23.dao.dataBase;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.GenrDTO;
import by.it_academy.jd2.Mk_JD2_98_23.core.dto.GenreCreateDTO;
import by.it_academy.jd2.Mk_JD2_98_23.dao.api.IGenreDao;
import by.it_academy.jd2.Mk_JD2_98_23.dao.dataBase.connection.Const;
import by.it_academy.jd2.Mk_JD2_98_23.dao.dataBase.connection.DatabaseConnectin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GenreDataBaseDao extends DatabaseConnectin implements IGenreDao {



    public GenreDataBaseDao() {
    }



    @Override
    public List<GenrDTO> get() {
        List<GenrDTO> genreDTOList = new ArrayList<>();
        String insert = "SELECT id, name FROM "+ Const.GENRE_TABLE;
        try {
            PreparedStatement ps = getDbConnection().prepareStatement(insert);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                genreDTOList.add(new GenrDTO(rs.getInt("id"),rs.getString("name")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return genreDTOList;
    }

    @Override
    public GenrDTO get(int id) {
        GenrDTO dto = null;
        String insert = "SELECT id, name FROM "+Const.GENRE_TABLE+" WHERE id = "+id;
        try {
            PreparedStatement ps = getDbConnection().prepareStatement(insert);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                dto = new GenrDTO(rs.getInt(Const.GENRE_ID), rs.getString(Const.GENRE_NAME));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return dto;
    }

    @Override
    public synchronized GenrDTO save(GenreCreateDTO gen) {
        GenrDTO dto = null;
        String insert = "INSERT INTO "+Const.GENRE_TABLE+"(name)  VALUES (?)";
        try {
            PreparedStatement ps = getDbConnection().prepareStatement(insert);
            ps.setString(1,gen.getName());
            ps.executeUpdate();
            insert = "SELECT id, name FROM "+ Const.GENRE_TABLE+" WHERE name = "+gen.getName();
            ps = getDbConnection().prepareStatement(insert);
            ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    dto = new GenrDTO(rs.getInt(Const.GENRE_ID), rs.getString(Const.GENRE_NAME));
                }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return dto;
    }
}
