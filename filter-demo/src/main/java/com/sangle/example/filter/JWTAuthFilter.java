package com.sangle.example.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.IOException;
import java.util.List;

public class JWTAuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.err.println("JWTAuthFilter initialized");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        if (request instanceof HttpServletRequest httpRequest) {
            System.err.println("Filter executed for: " + httpRequest.getRequestURI() + " " + httpRequest.getMethod());
            System.err.println("DispatcherType: " + httpRequest.getDispatcherType());
        }

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        System.err.println("JWTAuthFilter invoked");

        // Extract Authorization header
        String authHeader = httpRequest.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            httpResponse.getWriter().write("Unauthorized");
            return;
        }

        String token = authHeader.substring(7); // Remove "Bearer " prefix
        try {
            // Validate the JWT token (pseudo-code, replace with your logic)
            String username = validateAndExtractUsername(token);

            // Set authentication in the SecurityContext if valid
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            System.out.println("Authentication: " + (authentication != null ? authentication.getName() : "null"));

            SecurityContextHolder.getContext().setAuthentication(
                    new UsernamePasswordAuthenticationToken(username, null, List.of())
            );


        } catch (Exception e) {
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            httpResponse.getWriter().write("Invalid Token");
            return;
        }
        // Continue to the next filter
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("JWTAuthFilter destroyed");
    }

    private String validateAndExtractUsername(String token) throws Exception {
        // Pseudo-logic for token validation
        if ("validToken".equals(token)) {
            return "user123"; // Extract username from the token
        }
        throw new Exception("Invalid Token");
    }
}
