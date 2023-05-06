package by.it_academy.jd2.Mk_JD2_98_23.controllers.web.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@WebServlet(urlPatterns = "/cookie")
public class CookieTest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        Cookie[] reqCookies = req.getCookies();
        String firstName = null;
        String lastName = null;
        Cookie firstCookie = null;
        Cookie lastCookie = null;

        if (req.getParameter("firstName")!=null){
            firstName = req.getParameter("firstName");
            firstCookie = new Cookie("firstName",firstName);
            firstCookie.setMaxAge(Math.toIntExact(TimeUnit.DAYS.toSeconds(1)));
        }
        else if (reqCookies != null) {
            for (Cookie cookie : reqCookies) {
                if (Objects.equals(cookie.getName(), "firstName")) {
                    firstName = cookie.getValue();
                    firstCookie = cookie;
                }
            }
        } else {
            resp.setStatus(400);
        }



        if (req.getParameter("lastName")!=null) {
            lastName = req.getParameter("lastName");
            lastCookie = new Cookie("lastName",lastName);
            lastCookie.setMaxAge(Math.toIntExact(TimeUnit.DAYS.toSeconds(1)));
        }else if (reqCookies != null){
            for (Cookie cookie:reqCookies) {
                 if (Objects.equals(cookie.getName(), "lastName")){
                     lastName = cookie.getValue();
                    lastCookie = cookie;
                }
            }
        }else {
            resp.setStatus(400);
        }

        if (firstName!=null && lastName!=null) {
            resp.addCookie(firstCookie);
            resp.addCookie(lastCookie);
            writer.write("Hello" + firstName + " " + lastName);
        }
    }

}
