package com.example.finmangerfrontend.service;

import com.example.finmangerfrontend.dto.ApplicationUser;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LoginService {
    private final RestTemplate restTemplate;
    private final AuthenticationManager authenticationManager;

    public LoginService( RestTemplate restTemplate, AuthenticationManager authenticationManager ) {
        this.restTemplate = restTemplate;
        this.authenticationManager = authenticationManager;
    }

    public String login( String username, String password ) {
        String loginUrl = "http://localhost:8080/api/auth/signin";
        ApplicationUser applicationUser = new ApplicationUser( username, password );

        ResponseEntity<String> response =
                restTemplate.postForEntity( loginUrl, applicationUser, String.class );

        return response.getBody();
    }
}
