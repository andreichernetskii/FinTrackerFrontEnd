package com.example.finmangerfrontend.service;

import com.example.finmangerfrontend.dto.Limit;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class LimitsService {
    private RestTemplate restTemplate;

    public LimitsService( RestTemplate restTemplate ) {
        this.restTemplate = restTemplate;
    }

    public List<Limit> getLimits() {
        String url = "http://localhost:8080/api/v1/limits/all";
        return restTemplate.getForObject( url, List.class );
    }
}
