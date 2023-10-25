package com.example.finmangerfrontend.service;

import com.example.finmangerfrontend.dto.Limit;
import com.example.finmangerfrontend.dto.Operation;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import org.springframework.http.HttpHeaders;

import java.util.List;

@Service
public class LimitsService {
    private final RestTemplate restTemplate;

    public LimitsService( RestTemplate restTemplate ) {
        this.restTemplate = restTemplate;
    }

    public List<Limit> getLimits() {
        String url = "http://localhost:8080/api/v1/limits/";

//        HttpServletRequest httpServletRequest = ( (ServletRequestAttributes) RequestContextHolder.getRequestAttributes() ).getRequest();
//        String username = httpServletRequest.getLocalName();
//
//
//        HttpHeaders headers = new HttpHeaders();
////        headers.setBasicAuth( "fgh@mail.com", "sdd" );
//
//
//        HttpEntity<String> entity = new HttpEntity<>( headers );
//
//        ResponseEntity<List<Limit>> response = restTemplate.exchange(
//                url,
//                HttpMethod.GET,
//                entity,
//                new ParameterizedTypeReference<List<Limit>>() {
//                }
//        );

        return restTemplate.getForObject( url, List.class );
//        return response.getBody();
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
