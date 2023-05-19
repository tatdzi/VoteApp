package by.it_academy.jd2.Mk_JD2_98_23.dao.dataBase;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.ArtistDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArtistsDatabaseHendler extends Configs{
    Connection dbConnection;
    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String url ="jdbc:postgresql://"+dbHost+dbPort+dbName;
        dbConnection = DriverManager.getConnection(url, dbUser,dbPass);
        return dbConnection;
    }
    public void save(String name){
        ArtistDTO dto;
        String insert = "INSERT INTO "+Const.ARTISTS_TABLE+"(name)  VALUES (?)";
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
    public List<ArtistDTO> get(){
        List<ArtistDTO> artistDTOList = new ArrayList<>();
        String insert = "SELECT id, name FROM "+Const.ARTISTS_TABLE;
        try {
            PreparedStatement ps = getDbConnection().prepareStatement(insert);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                artistDTOList.add(new ArtistDTO(rs.getInt("id"),rs.getString("name")));
            }
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return artistDTOList;
    }

    public ArtistDTO get(int id){
        ArtistDTO dto = new ArtistDTO(1,"gg");
        String insert = "SELECT id, name FROM "+Const.ARTISTS_TABLE+" WHERE id = "+id;
        try {
            PreparedStatement ps = getDbConnection().prepareStatement(insert);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                dto = new ArtistDTO(rs.getInt("id"), rs.getString("name"));
            }
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return dto;
    }
    public ArtistDTO get(String name){
        ArtistDTO dto = new ArtistDTO(2,"hh");
        String insert = "SELECT id, name FROM "+ Const.ARTISTS_TABLE+" WHERE name = "+name;
        try {
            PreparedStatement ps = getDbConnection().prepareStatement(insert);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                dto = new ArtistDTO(rs.getInt("id"), rs.getString("name"));
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
