package com.example.finmangerfrontend.service;

import com.example.finmangerfrontend.dto.ApplicationUser;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LoginService {
    private final RestTemplate restTemplate;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    public LoginService( RestTemplate restTemplate, AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder ) {
        this.restTemplate = restTemplate;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
    }

    public String login( String username, String password ) {
        String loginUrl = "http://localhost:8080/api/auth/signin";
        String encodedPassword = passwordEncoder.encode( password );

        ApplicationUser applicationUser = new ApplicationUser( username, encodedPassword );

        ResponseEntity<String> response =
                restTemplate.postForEntity( loginUrl, applicationUser, String.class );

        return response.getBody();
    }

    public String logoutUser() {
        String logoutUrl = "http://localhost:8080/api/auth/signout";
        ResponseEntity<String> response = restTemplate.postForEntity( logoutUrl, null, String.class );

        return response.getBody();
    }

    public String registerNewUser( String username, String password ) {
        String registrationUrl = "http://localhost:8080/api/auth/signup";
        String encodedPassword = passwordEncoder.encode( password );

        ApplicationUser applicationUser = new ApplicationUser( username, encodedPassword );

        ResponseEntity<String> response = restTemplate.postForEntity( registrationUrl, applicationUser, String.class );

        return response.getBody();
    }
}
