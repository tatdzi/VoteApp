package by.it_academy.jd2.Mk_JD2_98_23.controllers.web.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;


import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class IncodingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html; charset=utf-8");
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
