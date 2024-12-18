package com.sangle.example.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


    @GetMapping("/users")
    public List<String> getUsers(Authentication authentication) {
        return List.of("User1", "User2", "User3");
    }

    @PostMapping("/users")
    public String debugCsrf(HttpServletRequest request, CsrfToken csrfToken) {
        return csrfToken.getToken();
    }
}
