package com.example.finmangerfrontend.service;

import com.example.finmangerfrontend.configuration.StatefulRestTemplateInterceptor;
import com.example.finmangerfrontend.dto.ApplicationUser;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// todo: zmienić nazwę
@Service
public class LoginService {
    private final RestTemplate restTemplate;

    public LoginService( RestTemplate restTemplate ) {
        this.restTemplate = restTemplate;
    }

    public String login( String username, String password ) {
        String loginUrl = "http://localhost:8080/api/auth/signin";
        ApplicationUser applicationUser = new ApplicationUser( username, password );

        ResponseEntity<String> response = restTemplate.postForEntity( loginUrl, applicationUser, String.class );
        String str = getUsernameForShow();

        return response.getBody();
    }

    public String logoutUser() {
        String logoutUrl = "http://localhost:8080/api/auth/signout";
        ResponseEntity<String> response = restTemplate.postForEntity( logoutUrl, null, String.class );

        return response.getBody();
    }

    public String registerNewUser( String username, String password ) {
        String registrationUrl = "http://localhost:8080/api/auth/signup";
        ApplicationUser applicationUser = new ApplicationUser( username, password );

        ResponseEntity<String> response = restTemplate.postForEntity( registrationUrl, applicationUser, String.class );

        return response.getBody();
    }

    public String getUsernameForShow() {
        String body = null;

        for ( ClientHttpRequestInterceptor interceptor : restTemplate.getInterceptors() ) {
            if ( interceptor instanceof StatefulRestTemplateInterceptor ) {
                body = ((StatefulRestTemplateInterceptor) interceptor).getBody();
            }
        }

        return body;
    }
}
