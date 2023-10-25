package com.example.finmangerfrontend.configuration;

import com.example.finmangerfrontend.service.ApplicationUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    // todo: przeanalizować
//    @Bean
//    public PasswordEncoder configurePasswordEncoder() {
//        PasswordEncoder passEncoder = NoOpPasswordEncoder.getInstance();
//        return passEncoder;
//    }

    @Bean
    public PasswordEncoder configurePasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain configureChain( HttpSecurity httpSecurity, ApplicationUserService applicationUserService ) throws Exception {
        httpSecurity
                .csrf( customizer -> customizer.disable() )
                .headers( customizer -> customizer.disable() )
                .authorizeHttpRequests( customizer -> {
                    customizer.requestMatchers( "/" ).permitAll();
                    customizer.anyRequest().authenticated();
                } )
                .formLogin( Customizer.withDefaults() )
                .authenticationProvider( applicationUserService )
        ;

        return httpSecurity.build();
    }

}
