package com.sangle.example.filter;

import jakarta.servlet.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;


public class CustomFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.err.println("CustomFilter.init");
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.err.println("CustomFilter.doFilter");
    }

    @Override
    public void destroy() {
        System.err.println("CustomFilter.destroy");
        Filter.super.destroy();
    }
}
