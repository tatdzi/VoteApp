package by.it_academy.jd2.Mk_JD2_98_23.controllers.web.servlets;

import by.it_academy.jd2.Mk_JD2_98_23.core.dto.GenreCreateDTO;
import by.it_academy.jd2.Mk_JD2_98_23.core.entity.GenrEntity;
import by.it_academy.jd2.Mk_JD2_98_23.service.api.IGenreService;
import by.it_academy.jd2.Mk_JD2_98_23.service.factory.GenreServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/genre")
public class GenreServlet extends HttpServlet {
    private IGenreService genreService;

    public GenreServlet() {
        genreService = GenreServiceFactory.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        List<GenrEntity> genrDTOList = genreService.get();
        StringBuilder builder = new StringBuilder();
        for (GenrEntity genr:genrDTOList) {
            builder.append("["+genr.getName()+",  "+genr.getId()+"]<br>");
        }
        writer.write(builder.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        GenreCreateDTO dto = new GenreCreateDTO(req.getParameter("name"));
        genreService.save(dto);
    }
}
