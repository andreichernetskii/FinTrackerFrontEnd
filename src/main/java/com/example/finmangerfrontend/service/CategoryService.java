package com.example.finmangerfrontend.service;

import com.example.finmangerfrontend.configuration.AppValuesConfig;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CategoryService {
    private final RestTemplate restTemplate;
    private final AppValuesConfig appValuesConfig;

    public CategoryService( RestTemplate restTemplate, AppValuesConfig appValuesConfig ) {
        this.restTemplate = restTemplate;
        this.appValuesConfig = appValuesConfig;
    }

    public List<String> getCategories() {
        String url = appValuesConfig.getMainUrl() + "/api/v1/transactions/categories?";
        return restTemplate.getForObject( url, List.class );
    }
}
