package com.example.finmangerfrontend.service;

import com.example.finmangerfrontend.dto.FilterParameters;
import com.example.finmangerfrontend.dto.FinancialTransaction;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FinancialTransactionService {
    private final RestTemplate restTemplate;

    public FinancialTransactionService( RestTemplate restTemplate ) {
        this.restTemplate = restTemplate;
    }

    public void senNewFinancialTransaction( FinancialTransaction financialTransaction ) {
        restTemplate.postForEntity( "http://client-backend:8080/api/v1/transactions/", financialTransaction, String.class );
    }

    public void deleteFinancialTransaction( Long id ) {
        restTemplate.delete( "http://client-backend:8080/api/v1/transactions/" + id );
    }

    public void updateFinancialTransaction( FinancialTransaction financialTransaction ) {
        restTemplate.put( "http://client-backend:8080/api/v1/transactions/", financialTransaction );
    }

    public List<FinancialTransaction> getFinancialTransactions( FilterParameters filterParameters ) {
        String filter = filterParameters.getParamsAsURL();
        String url = "http://client-backend:8080/api/v1/transactions/" + filter;

        ResponseEntity<List<FinancialTransaction>> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<FinancialTransaction>>() {}
        );
        return responseEntity.getBody();
    }

    public Double getAnnualBalance( FilterParameters filterParameters ) {
        String url = "http://client-backend:8080/api/v1/transactions/annual?" + filterParameters.getParamsAsURL();
        Double response = restTemplate.getForObject( url, Double.class );
        return response;
    }

    public List<String> getTransactionTypes() {
        String url = "http://client-backend:8080/api/v1/transactions/types";
        return restTemplate.getForObject( url, List.class );
    }

}
