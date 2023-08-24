package com.example.finmangerfrontend.service;

import com.example.finmangerfrontend.dto.Alert;
import com.example.finmangerfrontend.dto.FilterParameters;
import com.example.finmangerfrontend.dto.IncomeExpense;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ApiService {
    private RestTemplate restTemplate;

    public ApiService( RestTemplate restTemplate ) {
        this.restTemplate = restTemplate;
    }

    public void sendNewIncomeExpense( IncomeExpense incomeExpense ) {
        restTemplate.postForEntity( "http://localhost:8080/api/v1/incomes-expenses", incomeExpense, String.class );
    }

    public void deleteOperation( Long id ) {
        restTemplate.delete( "http://localhost:8080/api/v1/incomes-expenses/operations/" + id );
    }

    public void updateIncomeExpense( IncomeExpense incomeExpense ) {
        restTemplate.put( "http://localhost:8080/api/v1/incomes-expenses/operations/update-operation", incomeExpense );
    }

    public List<IncomeExpense> getOperations( FilterParameters filterParameters ) {
        String filter = filterParameters.getParamsAsURL();
        String url = "http://localhost:8080/api/v1/incomes-expenses/operations/statistics?" + filter;
        List<IncomeExpense> response = restTemplate.getForObject( url, List.class );
        return response;
    }

    public Double getAnnualBalance( FilterParameters filterParameters ) {
        String url = "http://localhost:8080/api/v1/incomes-expenses/operations/annual?" + filterParameters.getParamsAsURL();
        Double response = restTemplate.getForObject( url, Double.class );
        return response;
    }

    public Double getAnnualBalance( ) {
        String url = "http://localhost:8080/api/v1/incomes-expenses/operations/annual?";
        Double response = restTemplate.getForObject( url, Double.class );
        return response;
    }

    public List<String> getCategories() {
        String url = "http://localhost:8080/api/v1/incomes-expenses/categories?";
        List<String> categories = restTemplate.getForObject( url, List.class );
        return categories;
    }

    public List<Alert> getAlerts() {
        String url = "http://localhost:8080/api/v1/alerts";
        return restTemplate.getForObject( url, List.class );
    }
}
