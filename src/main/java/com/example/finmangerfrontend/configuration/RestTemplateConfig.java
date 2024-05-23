package com.example.finmangerfrontend.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.annotation.SessionScope;

@Configuration
public class RestTemplateConfig {
    @Bean
    @SessionScope
    public RestTemplate createRestTemplate( RestTemplateBuilder templateBuilder ) {
        RestTemplate restTemplate = templateBuilder.build();
        // allows catching and keeping cookies for stateful communication
        restTemplate.getInterceptors().add( new StatefulRestTemplateInterceptor() );

        return restTemplate;

//        return new RestTemplate();
    }
}
