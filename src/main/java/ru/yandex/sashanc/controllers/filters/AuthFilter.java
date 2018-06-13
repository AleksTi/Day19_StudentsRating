package ru.yandex.sashanc.controllers.filters;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter(urlPatterns = "/inner/*", filterName = "auth-filter")
public class AuthFilter implements Filter {
    private static final Logger logger = Logger.getLogger(AuthFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession httpSession = ((HttpServletRequest) request).getSession();
        if (httpSession.getAttribute("email") != null) {
            chain.doFilter(request, response);
        } else {
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/index.jsp");
        }
        logger.info("\"AuthFilter.doFilter()\" method have done");
    }

    @Override
    public void destroy() {

    }
}
