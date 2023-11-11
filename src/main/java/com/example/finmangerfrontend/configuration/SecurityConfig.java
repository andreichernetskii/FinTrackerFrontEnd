package com.example.finmangerfrontend.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain configureChain( HttpSecurity httpSecurity ) throws Exception {
        httpSecurity
                .csrf( customizer -> customizer.disable() )
                .authorizeHttpRequests( customizer -> {
                    customizer.requestMatchers( "/login" ).permitAll();
                    customizer.anyRequest().authenticated();
                } )
                .formLogin( form -> {
                    form.loginPage( "/login" ).permitAll();
                    form.successForwardUrl( "/limits" );
                } );



        return httpSecurity.build();
    }
}
