package com.sangle.example.filter;

import com.sangle.example.util.JWTProvider;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

@Component
public class JWTAuthorizationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            System.err.println("JWTAuthorizationFilter");
            String header = request.getHeader("Authorization");
            if (header == null || !header.startsWith("Bearer ")) {
                System.err.println("No jwt fond in request header");
                return;
            }

            String token = header.substring(7);
            String email = JWTProvider.validateAndParseToken(token);
            if (email.isEmpty()) {
                System.err.println("Invalid token");
                return;
            }

            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    email,
                    null,
                    Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);

        } catch (Exception ex) {
            System.err.println(ex);
        } finally {
            filterChain.doFilter(request, response);
        }
    }
}
