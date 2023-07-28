package com.example.finmangerfrontend.service;

import com.example.finmangerfrontend.dto.IncomeExpenseManager;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.jar.JarOutputStream;

@Service
public class IncomeExpenseService {
    private RestTemplate restTemplate;

    public IncomeExpenseService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void sendNewIncomeExpense(IncomeExpenseManager incomeExpenseManager) {
        restTemplate.postForEntity("http://localhost:8080/api/v1/incomes-expenses", incomeExpenseManager, String.class);
    }

    public List<IncomeExpenseManager> getOperations() {
        System.out.println("Sending request");
        ParameterizedTypeReference<List<IncomeExpenseManager>> responseType =
                new ParameterizedTypeReference<List<IncomeExpenseManager>>() {};

        // GET-request to DB
        ResponseEntity<List<IncomeExpenseManager>> response =
                restTemplate.exchange("http://localhost:8080/api/v1/incomes-expenses/operations",
                        HttpMethod.GET,
                        null,
                        responseType);

        // list of object from response body
        List<IncomeExpenseManager> operations = response.getBody();

        // Теперь у вас есть список объектов, который можно использовать
        return operations;
    }
}
