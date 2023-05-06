package by.it_academy.jd2.Mk_JD2_98_23.controllers.web.servlets;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.ArtistCreateDTO;
import by.it_academy.jd2.Mk_JD2_98_23.core.dto.ArtistDTO;
import by.it_academy.jd2.Mk_JD2_98_23.service.ArtistService;
import by.it_academy.jd2.Mk_JD2_98_23.service.api.IArtistService;
import by.it_academy.jd2.Mk_JD2_98_23.service.factory.ArtistServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/artists")
public class ArtistServlet extends HttpServlet {
    private IArtistService artistService;

    public ArtistServlet() {
        artistService = ArtistServiceFactory.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        List<ArtistDTO> artistDTOList = artistService.get();
        StringBuilder builder = new StringBuilder();
        for (ArtistDTO artist:artistDTOList){
            builder.append("["+artist.getName()+",  "+artist.getId()+"]<br>");
        }
        writer.write(builder.toString());


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        ArtistCreateDTO dto = new ArtistCreateDTO(req.getParameter("name"));
        artistService.save(dto);
    }
}
