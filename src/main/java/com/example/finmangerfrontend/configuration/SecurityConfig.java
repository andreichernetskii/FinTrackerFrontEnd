package com.example.finmangerfrontend.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.HttpRequestWrapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final SimpleAuthenticationSuccessHandler successHandler;

    public SecurityConfig( SimpleAuthenticationSuccessHandler successHandler ) {
        this.successHandler = successHandler;
    }

    @Bean
    public SecurityFilterChain configureChain( HttpSecurity httpSecurity ) throws Exception {
        httpSecurity
                .csrf( customizer -> customizer.disable() )
                .sessionManagement( session -> session.sessionCreationPolicy( SessionCreationPolicy.STATELESS ) )
                .authorizeHttpRequests( customizer -> {
                    customizer.requestMatchers( "/login" ).permitAll();
                    customizer.requestMatchers( "/login-processing" ).permitAll();
                    customizer.anyRequest().authenticated();
                } )
                .formLogin( form -> {
                    form.loginPage( "/login" ).permitAll();
//                    form.successHandler( successHandler );
//                    form.successForwardUrl( "/limits" );
                    form.defaultSuccessUrl( "/" );
                } );

        return httpSecurity.build();
    }

    @Bean
    public AuthenticationSuccessHandler successHandler() {
        return new SimpleUrlAuthenticationSuccessHandler( "/limits" );
    }

    @Bean
    public AuthenticationManager authenticationManager( AuthenticationConfiguration authConfig ) throws Exception {
        return authConfig.getAuthenticationManager();
    }
}
