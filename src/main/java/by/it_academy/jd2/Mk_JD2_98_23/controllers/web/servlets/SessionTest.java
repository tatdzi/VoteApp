package by.it_academy.jd2.Mk_JD2_98_23.controllers.web.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Objects;

@WebServlet(urlPatterns = "/session")
public class SessionTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Map<String, String[]> paramete = req.getParameterMap();
        HttpSession session = req.getSession();
        PrintWriter writer = resp.getWriter();
        if (!paramete.isEmpty()){
            for (String name:paramete.keySet()){
                if (Objects.equals(name,"firstName")){
                    session.setAttribute("firstName",paramete.get(name)[0]);
                }else if (Objects.equals(name,"lastName")){
                    session.setAttribute("lastName",paramete.get(name)[0]);
                }
            }
        }

        if (session.getAttribute("firstName")!= null && session.getAttribute("lastName")!= null){
            writer.write("Hello "+(String) session.getAttribute("firstName")+" "+(String) session.getAttribute("lastName"));
        }else{
            resp.setStatus(400);
            writer.write("error");
        }

    }
}
