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
        List<IncomeExpense> response = restTemplate.getForObject("http://localhost:8080/api/v1/incomes-expenses/operations", List.class);
        return response;
    }

    public List<IncomeExpense> getOperationsYearAndMonth(int year, int month) {
        String url = "http://localhost:8080/api/v1/incomes-expenses/operations/statistics" + "?year=" + year + "&month=" + month;
        List<IncomeExpense> response = restTemplate.getForObject(url, List.class);
        return response;
    }

    public List<IncomeExpense> getOperationsMonth(int month) {
        String url = "http://localhost:8080/api/v1/incomes-expenses/operations/statistics" + "?month=" + month;
        List<IncomeExpense> response = restTemplate.getForObject(url, List.class);
        return response;
    }

    public List<IncomeExpense> getOperationsYear(int year) {
        String url = "http://localhost:8080/api/v1/incomes-expenses/operations/statistics" + "?year=" + year;
        List<IncomeExpense> response = restTemplate.getForObject(url, List.class);
        return response;
    }

    public void deleteOperation(Long id) {
        restTemplate.delete("http://localhost:8080/api/v1/incomes-expenses/operations/" + id);
    }

    public void updateIncomeExpense(IncomeExpense incomeExpense) {
        restTemplate.put("http://localhost:8080/api/v1/incomes-expenses/operations/update-operation", incomeExpense);
    }


}
