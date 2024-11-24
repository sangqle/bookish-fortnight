package com.sangle.example.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;

public class VisitorCounterFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.err.println("VisitorCounterFilter.init");
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.err.println("VisitorCounterFilter.doFilter");
        Optional<HttpSession> session = Optional.ofNullable(((HttpServletRequest) servletRequest).getSession(false));
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.err.println("VisitorCounterFilter.destroy");
        Filter.super.destroy();
    }
}
