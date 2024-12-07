package com.sangle.example.util;

public class JWTProvider {
    public static String validateAndParseToken(String token) {
        // Simple way to validate token
        if("validToken".equals(token)) {
            return "sang@gmail.com";
        }
        return "";
    }
}
