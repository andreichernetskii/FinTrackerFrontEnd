package com.example.finmangerfrontend.service;

import com.example.finmangerfrontend.configuration.AppValuesConfig;
import com.example.finmangerfrontend.dto.Alert;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class AlertService {
    private final RestTemplate restTemplate;
    private final AppValuesConfig appValuesConfig;

    public AlertService( RestTemplate restTemplate, AppValuesConfig appValuesConfig ) {
        this.restTemplate = restTemplate;
        this.appValuesConfig = appValuesConfig;
    }

    public List<Alert> getAlerts() {
        String url = appValuesConfig.getMainUrl() + "/api/v1/alerts/";
        return restTemplate.getForObject( url, List.class );
    }
}
