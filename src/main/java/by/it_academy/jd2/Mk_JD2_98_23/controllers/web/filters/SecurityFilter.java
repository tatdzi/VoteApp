package by.it_academy.jd2.Mk_JD2_98_23.controllers.web.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;

@WebServlet(urlPatterns = "/admin/*")
public class SecurityFilter implements Filter {
    private boolean active = false;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String act = filterConfig.getInitParameter("active");
        if (act != null){
            active = (act.toUpperCase().equals("TRUE"));

        }

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        if (active) {

        }
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
