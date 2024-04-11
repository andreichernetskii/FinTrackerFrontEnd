package com.example.finmangerfrontend.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// This class configures resource handling for the application
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers( ResourceHandlerRegistry registry ) {
        // Add a resource handler for URLs starting with "/static/".
        // Map these URLs to resources located in the "classpath:/static/" directory
        registry.addResourceHandler( "/static/**" ).addResourceLocations( "classpath:/static/" );
    }
}

