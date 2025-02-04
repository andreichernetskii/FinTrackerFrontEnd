package com.example.finmangerfrontend.service;

import com.example.finmangerfrontend.dto.ApplicationUser;
import com.example.finmangerfrontend.configuration.AppValuesConfig;
import com.example.finmangerfrontend.dto.RegistrationForm;
import lombok.extern.log4j.Log4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Log4j
@Service
public class LoginService {

    private final RestTemplate restTemplate;
    private final AppValuesConfig appValuesConfig;

    public LoginService( RestTemplate restTemplate, AppValuesConfig appValuesConfig ) {
        this.restTemplate = restTemplate;
        this.appValuesConfig = appValuesConfig;
    }

    public String login( String username, String password ) {
        String loginUrl = appValuesConfig.getMainUrl() + "/api/auth/signin";
        ApplicationUser applicationUser = new ApplicationUser( username, password );

        ResponseEntity<String> response = restTemplate.postForEntity( loginUrl, applicationUser, String.class );

        log.debug("Headers: " + response.getHeaders());
        log.debug("All response " + response);

        return response.getBody();
    }

    public String logoutUser() {
        String logoutUrl = appValuesConfig.getMainUrl() + "/api/auth/signout";
        ResponseEntity<String> response = restTemplate.postForEntity( logoutUrl, null, String.class );

        return response.getBody();
    }

    public String registerNewUser( RegistrationForm registrationForm ) {
        String registrationUrl = appValuesConfig.getMainUrl() + "/api/auth/signup";
        ApplicationUser applicationUser = new ApplicationUser(
                registrationForm.getUsername(),
                registrationForm.getPassword(),
                registrationForm.getDemo()
        );

        ResponseEntity<String> response = restTemplate.postForEntity( registrationUrl, applicationUser, String.class );

        return response.getBody();
    }

    // for showing username in the upper right corner
    public String getUsernameForShow() {
        String getNameUrl = appValuesConfig.getMainUrl() + "/api/auth/username";
        return restTemplate.getForObject( getNameUrl, String.class );
    }
}
