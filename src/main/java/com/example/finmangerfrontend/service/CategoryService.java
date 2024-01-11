package com.example.finmangerfrontend.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CategoryService {
    private final RestTemplate restTemplate;

    public CategoryService( RestTemplate restTemplate ) {
        this.restTemplate = restTemplate;
    }

    public List<String> getCategories() {
        String url = "http://localhost:8080/api/v1/transactions/categories?";
        List<String> categories = restTemplate.getForObject( url, List.class );
        return categories;
    }
}
