package com.sangle.example.configuration;

import com.sangle.example.filter.CustomFilter;
import com.sangle.example.filter.FilterChainImpl;
import com.sangle.example.filter.VisitorCounterFilter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class ServletConfig {

}
