package com.example.finmangerfrontend.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


// class for keeping some global values from application.properties file
@Configuration
public class AppValuesConfig {
    @Value( "${app.mainUrl}" )
    private String mainUrl;

    public String getMainUrl() {
        return mainUrl;
    }
}
