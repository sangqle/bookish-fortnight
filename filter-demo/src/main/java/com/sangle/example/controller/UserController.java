package com.sangle.example.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @GetMapping("/users")
    public String getUsers(Authentication authentication) {
        System.err.println("User: " + authentication.getName());
        System.err.println("Authorities: " + authentication.getAuthorities());

        return "Return list of user";
    }
}
