package com.sangle.example.auth;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class CustomAuthentication implements Authentication {
    private final String principal; // User identity, e.g., username or ID
    private boolean authenticated;

    public CustomAuthentication(String principal, boolean authenticated) {
        this.principal = principal;
        this.authenticated = authenticated;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null; // Return authorities/roles if needed
    }

    @Override
    public Object getCredentials() {
        return null; // Return credentials if applicable
    }

    @Override
    public Object getDetails() {
        return null; // Return additional details if applicable
    }

    @Override
    public Object getPrincipal() {
        return principal; // Return the principal
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        this.authenticated = isAuthenticated;
    }

    @Override
    public String getName() {
        return principal; // Return a name or identifier for the principal
    }
}
