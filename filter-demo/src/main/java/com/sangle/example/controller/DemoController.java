package com.sangle.example.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@CrossOrigin(origins = "https://viblo.asia") // Allow requests from this origin
@RestController
@RequestMapping("/api")
public class DemoController {

    @GetMapping("/public-data")
    public String publicData() {
        return "This is public data";
    }

    @GetMapping("/private-data")
    public String privateData(Authentication authentication) {
        return "This is private data for: " + authentication.getName();
    }
}