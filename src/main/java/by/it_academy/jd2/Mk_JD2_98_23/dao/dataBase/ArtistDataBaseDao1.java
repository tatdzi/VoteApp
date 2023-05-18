package by.it_academy.jd2.Mk_JD2_98_23.dao.dataBase;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.ArtistDTO;
import by.it_academy.jd2.Mk_JD2_98_23.dao.api.IArtistDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
/*
public class ArtistDataBaseDao1 {


    public ArtistDataBaseDao1() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String url = "jdbc:postgresql://localhost:5432/votes";
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "postgres");

        try {
            Connection conn = DriverManager.getConnection(url, props);
            Statement st = conn.createStatement();
            st.executeQuery("INSERT INTO app.artists (name) VALUES ('Rosalía')");
            st.executeQuery("INSERT INTO app.artists (name) VALUES ('Glenn Danzig')");
            st.executeQuery("INSERT INTO app.artists (name) VALUES ('Billie Eilish')");
            st.executeQuery("INSERT INTO app.artists (name) VALUES ('Burna Boy')");
            st.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


    @Override
    public List<ArtistDTO> get() {
            List<ArtistDTO> result = new ArrayList<>();
            try {
                Connection conn = DriverManager.getConnection(url, props);
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery("SELECT id, name FROM app.artists");
                while (rs.next()){
                    result.add(new ArtistDTO(rs.getInt("id"),rs.getString("name")));
                }
                rs.close();
                st.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
        }
            return ;
    }

    @Override
    public ArtistDTO get(int id) {
        return artists.get(id);
    }

    @Override
    public synchronized ArtistDTO save(ArtistCreateDTO gen) {
        ArtistDTO dto = new ArtistDTO(artists.size()+1, gen.getName());
            this.artists.put(dto.getId(),dto);

        return dto;
    }
}

 */
