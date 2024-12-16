package com.sangle.example.configuration;

import com.sangle.example.filter.JWTAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    JWTAuthorizationFilter authorizationFilter;

    // SecurityFilterChain0 for /api/**
    @Bean
    public SecurityFilterChain apiFilterChain(HttpSecurity http) throws Exception {
        http
                .securityMatcher("/api/**") // Match URLs starting with /api/**
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated() // All requests must be authenticated
                ).addFilterBefore(authorizationFilter, UsernamePasswordAuthenticationFilter.class); // Add JWTAuthorizationFilter before SecurityFilterChain

        System.err.println("SecurityFilterChain0 applied for /api/**");
        return http.build();
    }

    // SecurityFilterChainn for other requests
    @Bean
    public SecurityFilterChain defaultFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // All other requests are permitted
                );

        System.err.println("Default SecurityFilterChain applied for all other requests");
        return http.build();
    }
}
