package com.example.finmangerfrontend.service;

import com.example.finmangerfrontend.dto.Alert;
import com.example.finmangerfrontend.dto.FilterParameters;
import com.example.finmangerfrontend.dto.FinancialTransaction;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ApiService {
    private final RestTemplate restTemplate;

    public ApiService( RestTemplate restTemplate ) {
        this.restTemplate = restTemplate;
    }

    public void sendNewIncomeExpense( FinancialTransaction financialTransaction ) {
        restTemplate.postForEntity( "http://localhost:8080/api/v1/transactions/", financialTransaction, String.class );
    }

    public void deleteOperation( Long id ) {
        restTemplate.delete( "http://localhost:8080/api/v1/transactions/" + id );
    }

    public void updateIncomeExpense( FinancialTransaction financialTransaction ) {
        restTemplate.put( "http://localhost:8080/api/v1/transactions/", financialTransaction );
    }

    public List<FinancialTransaction> getOperations( FilterParameters filterParameters ) {
        String filter = filterParameters.getParamsAsURL();
        String url = "http://localhost:8080/api/v1/transactions/" + filter;

        ResponseEntity<List<FinancialTransaction>> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<FinancialTransaction>>() {}
        );
        return responseEntity.getBody();
    }

    public Double getAnnualBalance( FilterParameters filterParameters ) {
        String url = "http://localhost:8080/api/v1/transactions/annual?" + filterParameters.getParamsAsURL();
        Double response = restTemplate.getForObject( url, Double.class );
        return response;
    }

    public List<String> getCategories() {
        String url = "http://localhost:8080/api/v1/transactions/categories?";
        List<String> categories = restTemplate.getForObject( url, List.class );
        return categories;
    }

    public List<Alert> getAlerts() {
        String url = "http://localhost:8080/api/v1/alerts/";
        return restTemplate.getForObject( url, List.class );
    }
}
