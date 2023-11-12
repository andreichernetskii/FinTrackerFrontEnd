package com.example.finmangerfrontend.service;

import com.example.finmangerfrontend.dto.ApplicationUser;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LoginService {
    private final RestTemplate restTemplate;
    private final PasswordEncoder passwordEncoder;

    public LoginService( RestTemplate restTemplate, PasswordEncoder passwordEncoder ) {
        this.restTemplate = restTemplate;
        this.passwordEncoder = passwordEncoder;
    }

    public String login( String username, String password ) {
        String loginUrl = "http://localhost:8080/api/auth/signin";
        ApplicationUser applicationUser = new ApplicationUser( username, passwordEncoder.encode( password ) );

        ResponseEntity<String> response =
                restTemplate.postForEntity( loginUrl, applicationUser, String.class );

        return response.getBody();
    }
}
