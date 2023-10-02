package com.example.finmangerfrontend.service;

import com.example.finmangerfrontend.dto.Limit;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class LimitsService {
    private final RestTemplate restTemplate;

    public LimitsService( RestTemplate restTemplate ) {
        this.restTemplate = restTemplate;
    }

    public List<Limit> getLimits() {
        String url = "http://localhost:8080/api/v1/limits/";
        return restTemplate.getForObject( url, List.class );
    }

    public List<String> getLimitTypes() {
        String url = "http://localhost:8080/api/v1/limits/types";
        return restTemplate.getForObject( url, List.class );
    }

    public void addOrUpdateLimit( Limit limit ) {
        String url = "http://localhost:8080/api/v1/limits/";
        restTemplate.postForEntity( url, limit, String.class );
    }

    public void deleteLimit( String id ) {
        restTemplate.delete( new StringBuilder("http://localhost:8080/api/v1/limits/").append( id ).toString() );
    }
}
