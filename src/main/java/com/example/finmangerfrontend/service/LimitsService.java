package com.example.finmangerfrontend.service;

import com.example.finmangerfrontend.configuration.AppValuesConfig;
import com.example.finmangerfrontend.dto.Limit;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;

@Service
public class LimitsService {
    private final RestTemplate restTemplate;
    private final AppValuesConfig appValuesConfig;

    public LimitsService( RestTemplate restTemplate, AppValuesConfig appValuesConfig ) {
        this.restTemplate = restTemplate;
        this.appValuesConfig = appValuesConfig;
    }

    public List<Limit> getLimits() {
        String url = appValuesConfig.getMainUrl() + "/api/v1/limits/";
        return restTemplate.getForObject( url, List.class );
    }

    public List<String> getLimitTypes() {
        String url = appValuesConfig.getMainUrl() + "/api/v1/limits/types";
        return restTemplate.getForObject( url, List.class );
    }

    public void addNewLimit( Limit limit ) {
        limit.setCreationDate( LocalDate.now() ); // todo should it be inside setter?
        String url = appValuesConfig.getMainUrl() + "/api/v1/limits/";
        restTemplate.postForEntity( url, limit, String.class );
    }

    public void updateLimit( Limit limit ) {
        String url = appValuesConfig.getMainUrl() + "/api/v1/limits/" + limit.getId();
        restTemplate.put( url, limit );
    }

    public void deleteLimit( Long id ) {
        String url = appValuesConfig.getMainUrl() + "/api/v1/limits/";
        restTemplate.delete( url + id );
    }
}
