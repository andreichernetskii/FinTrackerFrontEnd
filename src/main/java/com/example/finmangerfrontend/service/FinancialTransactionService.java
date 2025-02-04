package com.example.finmangerfrontend.service;

import com.example.finmangerfrontend.configuration.AppValuesConfig;
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
    private final AppValuesConfig appValuesConfig;

    public FinancialTransactionService( RestTemplate restTemplate, AppValuesConfig appValuesConfig ) {
        this.restTemplate = restTemplate;
        this.appValuesConfig = appValuesConfig;
    }

    public void sendNewFinancialTransaction( FinancialTransaction financialTransaction ) {
        String addNewTransactionUrl = appValuesConfig.getMainUrl() + "/api/v1/transactions/";
        restTemplate.postForEntity( addNewTransactionUrl, financialTransaction, String.class );
    }

    public void deleteFinancialTransaction( Long id ) {
        String deleteTransactionUrl = appValuesConfig.getMainUrl() + "/api/v1/transactions/";
        restTemplate.delete( deleteTransactionUrl + id );
    }

    public void updateFinancialTransaction( FinancialTransaction financialTransaction ) {
        String updateTransactionUrl = appValuesConfig.getMainUrl() + "/api/v1/transactions/";
        restTemplate.put( updateTransactionUrl, financialTransaction );
    }

    public List<FinancialTransaction> getFinancialTransactions( FilterParameters filterParameters ) {
        String filter = filterParameters.getParamsAsURL();
        String getTransactionsListUrl = appValuesConfig.getMainUrl() + "/api/v1/transactions/";
        String url = getTransactionsListUrl + filter;

        ResponseEntity<List<FinancialTransaction>> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<FinancialTransaction>>() {}
        );
        return responseEntity.getBody();
    }

    public Double getAnnualBalance( FilterParameters filterParameters ) {
        String getAnnualBalanceUrl = appValuesConfig.getMainUrl() + "/api/v1/transactions/annual?";
        String url = getAnnualBalanceUrl + filterParameters.getParamsAsURL();
        Double response = restTemplate.getForObject( url, Double.class );
        return response;
    }

    public List<String> getTransactionTypes() {
        String getTransactionTypesUrl = appValuesConfig.getMainUrl() + "/api/v1/transactions/types";
        return restTemplate.getForObject( getTransactionTypesUrl, List.class );
    }

}
