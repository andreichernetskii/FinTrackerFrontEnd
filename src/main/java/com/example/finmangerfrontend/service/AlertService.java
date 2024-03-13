package com.example.finmangerfrontend.service;

import com.example.finmangerfrontend.dto.Alert;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class AlertService {
    private final RestTemplate restTemplate;

    public AlertService( RestTemplate restTemplate ) {
        this.restTemplate = restTemplate;
    }

    public List<Alert> getAlerts() {
        String url = "http://client-backend:8080/api/v1/alerts/";
        return restTemplate.getForObject( url, List.class );
    }
}
