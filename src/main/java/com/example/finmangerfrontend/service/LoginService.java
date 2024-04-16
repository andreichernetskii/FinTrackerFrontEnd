package com.example.finmangerfrontend.service;

import com.example.finmangerfrontend.dto.ApplicationUser;
import com.example.finmangerfrontend.configuration.GlobalValuesConfig;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LoginService {
    private final RestTemplate restTemplate;
    private final GlobalValuesConfig globalValuesConfig;

    public LoginService( RestTemplate restTemplate, GlobalValuesConfig globalValuesConfig ) {
        this.restTemplate = restTemplate;
        this.globalValuesConfig = globalValuesConfig;
    }

    public String login( String username, String password ) {
        String loginUrl = globalValuesConfig.getMainUrl() + "/api/auth/signin";
        ApplicationUser applicationUser = new ApplicationUser( username, password );

        ResponseEntity<String> response = restTemplate.postForEntity( loginUrl, applicationUser, String.class );

        return response.getBody();
    }

    public String logoutUser() {
        String logoutUrl = globalValuesConfig.getMainUrl() + "/api/auth/signout";
        ResponseEntity<String> response = restTemplate.postForEntity( logoutUrl, null, String.class );

        return response.getBody();
    }

    public String registerNewUser( String username, String password ) {
        String registrationUrl = globalValuesConfig.getMainUrl() + "/api/auth/signup";
        ApplicationUser applicationUser = new ApplicationUser( username, password );

        ResponseEntity<String> response = restTemplate.postForEntity( registrationUrl, applicationUser, String.class );

        return response.getBody();
    }

    // for showing username in the upper right corner
    public String getUsernameForShow() {
        String getNameUrl = globalValuesConfig.getMainUrl() + "/api/auth/username";
        return restTemplate.getForObject( getNameUrl, String.class );
    }
}
