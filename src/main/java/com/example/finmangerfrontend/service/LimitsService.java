package com.example.finmangerfrontend.service;

import com.example.finmangerfrontend.dto.Limit;
import com.example.finmangerfrontend.dto.Operation;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


import java.util.Collections;
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

    public void deleteLimit( Long id ) {
        restTemplate.delete( "http://localhost:8080/api/v1/limits/" + id );
    }
}
