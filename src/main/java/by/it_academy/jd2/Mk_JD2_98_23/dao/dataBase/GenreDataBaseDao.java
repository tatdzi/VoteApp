package by.it_academy.jd2.Mk_JD2_98_23.dao.dataBase;

/*
public class GenreDataBaseDao extends DatabaseConnectinFactory implements IGenreDao {


    public GenreDataBaseDao() {
    }


    @Override
    public List<GenrDTO> get() {
        List<GenrDTO> genreDTOList = new ArrayList<>();
        try (Connection conn = DatabaseConnectinFactory.getDbConnection();
             PreparedStatement st = conn.prepareStatement("SELECT genre_id, name FROM app.genre");
             ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                genreDTOList.add(new GenrDTO(rs.getInt("genre_id"), rs.getString("name")));
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
        try (Connection conn = DatabaseConnectinFactory.getDbConnection();
             PreparedStatement st = conn.prepareStatement("SELECT genre_id, name FROM app.genre WHERE genre_id = ?;");) {
            st.setInt(1, id);
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    dto = new GenrDTO(rs.getInt(Const.GENRE_ID), rs.getString(Const.GENRE_NAME));
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
    public synchronized GenrDTO save(GenreCreateDTO gen) {
        GenrDTO dto = null;
        try (Connection conn = DatabaseConnectinFactory.getDbConnection();
             PreparedStatement st = conn.prepareStatement("INSERT INTO app.genre (name)  VALUES (?) RETURNING genre_id");) {
            st.setString(1, gen.getName());
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    dto = new GenrDTO(rs.getInt("genre_id"), gen.getName());
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
