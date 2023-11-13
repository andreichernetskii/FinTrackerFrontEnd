package com.example.finmangerfrontend.service;

import com.example.finmangerfrontend.dto.Alert;
import com.example.finmangerfrontend.dto.FilterParameters;
import com.example.finmangerfrontend.dto.Operation;
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

    public void sendNewIncomeExpense( Operation operation ) {
        restTemplate.postForEntity( "http://localhost:8080/api/v1/incomes-expenses", operation, String.class );
    }

    public void deleteOperation( Long id ) {
        restTemplate.delete( "http://localhost:8080/api/v1/incomes-expenses/operations/" + id );
    }

    public void updateIncomeExpense( Operation operation ) {
        restTemplate.put( "http://localhost:8080/api/v1/incomes-expenses/operations/update-operation", operation );
    }

    public List<Operation> getOperations( FilterParameters filterParameters ) {
        String filter = filterParameters.getParamsAsURL();
        String url = "http://localhost:8080/api/v1/incomes-expenses/operations/statistics?" + filter;

        ResponseEntity<List<Operation>> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Operation>>() {}
        );
        return responseEntity.getBody();
    }

    public Double getAnnualBalance( FilterParameters filterParameters ) {
        String url = "http://localhost:8080/api/v1/incomes-expenses/operations/annual?" + filterParameters.getParamsAsURL();
        Double response = restTemplate.getForObject( url, Double.class );
        return response;
    }

    public List<String> getCategories() {
        String url = "http://localhost:8080/api/v1/incomes-expenses/categories?";
        List<String> categories = restTemplate.getForObject( url, List.class );
        return categories;
    }

    public List<Alert> getAlerts() {
        String url = "http://localhost:8080/api/v1/alerts/";
        return restTemplate.getForObject( url, List.class );
    }
}
