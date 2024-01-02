package com.example.finmangerfrontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class})
public class FinMangerFrontEndApplication {

    public static void main( String[] args ) {
        SpringApplication.run( FinMangerFrontEndApplication.class, args );
    }

}
