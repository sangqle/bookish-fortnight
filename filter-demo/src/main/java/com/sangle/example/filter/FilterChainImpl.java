package com.sangle.example.filter;

import com.fasterxml.jackson.databind.util.ArrayIterator;
import jakarta.servlet.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Iterator;

@Component
public class FilterChainImpl implements FilterChain {
    private Iterator<Filter> filters;

    public FilterChainImpl(Filter... filters)
    {
        this.filters = new ArrayIterator<>(filters);
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response) throws IOException, ServletException {
        System.err.println("FilterChainImpl.doFilter");
        if (filters.hasNext())
        {
            filters.next().doFilter(request, response, this);
        }
    }
}
