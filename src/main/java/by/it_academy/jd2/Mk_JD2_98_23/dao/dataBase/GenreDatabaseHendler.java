package by.it_academy.jd2.Mk_JD2_98_23.dao.dataBase;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.GenrDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GenreDatabaseHendler extends Configs{
    Connection dbConnection;
    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String url ="jdbc:postgresql://"+dbHost+dbPort+dbName;
        dbConnection = DriverManager.getConnection(url, dbUser,dbPass);
        return dbConnection;
    }
    public void save(String name){
        GenrDTO dto;
        String insert = "INSERT INTO "+Const.GENRE_TABLE+"(name)  VALUES (?)";
        try {
        PreparedStatement ps = getDbConnection().prepareStatement(insert);
        ps.setString(1,name);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public List<GenrDTO> get(){
        List<GenrDTO> artistDTOList = new ArrayList<>();
        String insert = "SELECT id, name FROM "+Const.GENRE_TABLE;
        try {
            PreparedStatement ps = getDbConnection().prepareStatement(insert);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                artistDTOList.add(new GenrDTO(rs.getInt("id"),rs.getString("name")));
            }
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return artistDTOList;
    }

    public GenrDTO get(int id){
        GenrDTO dto = new GenrDTO(1,"gg");
        String insert = "SELECT id, name FROM "+Const.GENRE_TABLE+" WHERE id = "+id;
        try {
            PreparedStatement ps = getDbConnection().prepareStatement(insert);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                dto = new GenrDTO(rs.getInt(1), rs.getString(1));
            }
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return dto;
    }
    public GenrDTO get(String name){
        GenrDTO dto = new GenrDTO(2,"hh");
        String insert = "SELECT id, name FROM "+ Const.GENRE_TABLE+" WHERE name = "+name;
        try {
            PreparedStatement ps = getDbConnection().prepareStatement(insert);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                dto = new GenrDTO(rs.getInt(1), rs.getString(1));
            }
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return dto;
    }


}
