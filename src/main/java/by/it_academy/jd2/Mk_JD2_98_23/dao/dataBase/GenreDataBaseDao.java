package by.it_academy.jd2.Mk_JD2_98_23.dao.dataBase;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.GenrDTO;
import by.it_academy.jd2.Mk_JD2_98_23.core.dto.GenreCreateDTO;
import by.it_academy.jd2.Mk_JD2_98_23.dao.api.IGenreDao;
import by.it_academy.jd2.Mk_JD2_98_23.dao.dataBase.connection.Const;
import by.it_academy.jd2.Mk_JD2_98_23.dao.dataBase.connection.DatabaseConnectinFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GenreDataBaseDao extends DatabaseConnectinFactory implements IGenreDao {



    public GenreDataBaseDao() {
    }



    @Override
    public List<GenrDTO> get() {
        List<GenrDTO> genreDTOList = new ArrayList<>();
        String insert = "SELECT genre_id, name FROM "+ Const.GENRE_TABLE;
        try (Connection conn = DatabaseConnectinFactory.getDbConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(insert)){
            while (rs.next()){
                genreDTOList.add(new GenrDTO(rs.getInt("genre_id"),rs.getString("name")));
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
        String insert = "SELECT genre_id, name FROM "+Const.GENRE_TABLE+" WHERE genre_id = "+id;
        try(Connection conn = DatabaseConnectinFactory.getDbConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(insert)) {
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
        String insert = "INSERT INTO "+Const.GENRE_TABLE+"(name)  VALUES ('"+gen.getName()+"') RETURNING genre_id";
        try (Connection conn = DatabaseConnectinFactory.getDbConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(insert)){
            if (rs.next()){
                dto = new GenrDTO(rs.getInt("genre_id"),gen.getName());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return dto;
    }
}
