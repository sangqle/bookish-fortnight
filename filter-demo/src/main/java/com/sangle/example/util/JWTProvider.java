package com.sangle.example.util;

public class JWTProvider {
    public static String validateAndParseToken(String token) {
        // Simple way to validate token
        if("valid-jwt-token".equals(token)) {
            return "sang@gmail.com";
        }
        return "";
    }
}