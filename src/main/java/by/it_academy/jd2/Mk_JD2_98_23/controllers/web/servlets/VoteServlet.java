package by.it_academy.jd2.Mk_JD2_98_23.controllers.web.servlets;



import by.it_academy.jd2.Mk_JD2_98_23.core.dto.VoteCreateDTO;
import by.it_academy.jd2.Mk_JD2_98_23.service.api.IArtistService;
import by.it_academy.jd2.Mk_JD2_98_23.service.api.IGenreService;
import by.it_academy.jd2.Mk_JD2_98_23.service.api.IVoteService;
import by.it_academy.jd2.Mk_JD2_98_23.service.factory.ArtistServiceFactory;
import by.it_academy.jd2.Mk_JD2_98_23.service.factory.GenreServiceFactory;
import by.it_academy.jd2.Mk_JD2_98_23.service.factory.VoteServiceFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/vote")
public class VoteServlet extends HttpServlet {
    private static final String ARTIST_PARAM_NAME = "artist";
    private static final String GENRE_PARAM_NAME = "genre";
    private static final String INFO_PARAM_NAME = "text";
    private final IGenreService genreService;
    private final IArtistService artistService;
    private final IVoteService voteService;



    public VoteServlet() {
        this.genreService= GenreServiceFactory.getInstance();
        this.artistService= ArtistServiceFactory.getInstance();
        this.voteService= VoteServiceFactory.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("genre", genreService.get());
        req.setAttribute("artists",artistService.get());
        ObjectMapper objectMapper = new ObjectMapper();
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/ui/Vote.jspx");
        dispatcher.forward(req,resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Map<String,String[]> parametrMap = req.getParameterMap();
        String[] artistMap = req.getParameterMap().get(ARTIST_PARAM_NAME);
        if (artistMap.length>1){
            throw new IllegalArgumentException("too much artists");
        }
        Integer artist = null;
        if (artistMap.length == 1){
            artist = Integer.parseInt(artistMap[0]);
        }
        String[] genreRow = req.getParameterMap().get(GENRE_PARAM_NAME);
        Integer[] genre = new Integer[genreRow.length];
        List<Integer> genres = new ArrayList<>();
        for (int i = 0;i<genreRow.length;i++){
            genres.add(Integer.parseInt(genreRow[i]));
        }
        String[] infoRow = req.getParameterMap().get(INFO_PARAM_NAME);
        if (infoRow.length>1){
            throw new IllegalArgumentException("too much info");
        }
        String info = infoRow[0];
        voteService.save(new VoteCreateDTO(artist,genres,info));
        req.setAttribute("genre", voteService.getTopGenre());
        req.setAttribute("artists",voteService.getTopArtist());
        req.setAttribute("info",voteService.getInfoByDate());
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/ui/VoteResult.jspx");
        dispatcher.forward(req,resp);

    }
}
