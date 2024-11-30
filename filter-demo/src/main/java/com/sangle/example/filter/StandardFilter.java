package com.sangle.example.filter;

import jakarta.servlet.*;
import org.springframework.stereotype.Component;

import java.io.IOException;


//@WebFilter(filterName = "standardFilter", urlPatterns = "/*")
@Component
public class StandardFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.err.println("StandardFilter.init");
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.err.println("StandardFilter.doFilter");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.err.println("StandardFilter.destroy");
        Filter.super.destroy();
    }
}
