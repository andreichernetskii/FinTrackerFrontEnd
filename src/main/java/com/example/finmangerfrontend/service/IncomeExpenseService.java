package com.example.finmangerfrontend.service;

import com.example.finmangerfrontend.dto.IncomeExpense;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class IncomeExpenseService {
    private RestTemplate restTemplate;

    public IncomeExpenseService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void sendNewIncomeExpense(IncomeExpense incomeExpense) {
        restTemplate.postForEntity("http://localhost:8080/api/v1/incomes-expenses", incomeExpense, String.class);
    }

    public List<IncomeExpense> getOperations() {
//        ParameterizedTypeReference<List<IncomeExpenseManager>> responseType =
//                new ParameterizedTypeReference<List<IncomeExpenseManager>>() {};

        // GET-request to DB
//        ResponseEntity<List<IncomeExpenseManager>> response =
//                restTemplate.exchange("http://localhost:8080/api/v1/incomes-expenses/operations",
//                        HttpMethod.GET,
//                        null,
//                        responseType);

       List<IncomeExpense> response=
                restTemplate.getForObject("http://localhost:8080/api/v1/incomes-expenses/operations",
                        List.class);

        // list of object from response body
//        List<IncomeExpenseManager> operations = response.getBody();

      //  return operations;
        return response;
    }

    public void deleteOperation(Long id) {
//        ResponseEntity<Void> response = restTemplate.exchange(
//                "http://localhost:8080/api/v1/incomes-expenses/operations/" + id,
//                HttpMethod.DELETE,
//                null,
//                Void.class
//        );
        restTemplate.delete("http://localhost:8080/api/v1/incomes-expenses/operations/" + id);
    }

    public void updateIncomeExpense(IncomeExpense incomeExpense) {
        restTemplate.put("http://localhost:8080/api/v1/incomes-expenses/operations/update-operation", incomeExpense);
    }
}
