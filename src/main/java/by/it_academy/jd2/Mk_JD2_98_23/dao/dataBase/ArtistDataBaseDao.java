package by.it_academy.jd2.Mk_JD2_98_23.dao.dataBase;

/*
public class ArtistDataBaseDao extends DatabaseConnectinFactory implements IArtistDao {



    public ArtistDataBaseDao() {
    }

    @Override
    public List<ArtistDTO> get() {
        List<ArtistDTO> artistDTOList = new ArrayList<>();
        try (Connection conn = DatabaseConnectinFactory.getDbConnection();
             PreparedStatement st = conn.prepareStatement("SELECT artists_id, name FROM app.artists");
             ResultSet rs = st.executeQuery()){
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
        try (Connection conn = DatabaseConnectinFactory.getDbConnection();
             PreparedStatement st = conn.prepareStatement("SELECT artists_id, name FROM app.artists WHERE artists_id = ?;");
             ){
            st.setInt(1,id);
            try (ResultSet rs = st.executeQuery();) {
                while (rs.next()) {
                    dto = new ArtistDTO(rs.getInt("artists_id"), rs.getString("name"));
                }
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
        try (Connection conn = DatabaseConnectinFactory.getDbConnection();
             PreparedStatement st = conn.prepareStatement("INSERT INTO app.artists (name)  VALUES (?) RETURNING artists_id");){
            st.setString(1, gen.getName());
            try (ResultSet rs = st.executeQuery()){
                if (rs.next()){
                    dto=new ArtistDTO(rs.getInt("artists_id"),gen.getName());
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return dto;
    }
}

 */
