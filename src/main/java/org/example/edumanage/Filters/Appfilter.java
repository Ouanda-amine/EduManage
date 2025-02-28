package org.example.edumanage.Filters;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebFilter("/*")

public class Appfilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httprequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpresponse = (HttpServletResponse) servletResponse;

        String uri = httprequest.getRequestURI();
        HttpSession session = httprequest.getSession(false);


        if (uri.endsWith("login")) {
            if (session != null && session.getAttribute("user") != null) {
                httpresponse.sendRedirect(httprequest.getContextPath() + "/StudentServlet");
                return;
            }
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        if (session == null || session.getAttribute("user") == null) {
            httpresponse.sendRedirect(httprequest.getContextPath() + "/login");
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);




    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
