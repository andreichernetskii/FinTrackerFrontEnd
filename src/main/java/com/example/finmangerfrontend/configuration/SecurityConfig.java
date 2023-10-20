package com.example.finmangerfrontend.configuration;

import com.example.finmangerfrontend.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;

@Configuration
public class SecurityConfig {
    // todo: przeanalizować
    @Bean
    public SecurityFilterChain configureChain( HttpSecurity httpSecurity, UserService userService ) throws Exception {
        httpSecurity
                .csrf( customizer -> customizer.disable() )
                .headers( customizer -> customizer.disable() )
                .authorizeHttpRequests( customizer ->
                        customizer.requestMatchers( "/" ).permitAll() )
                .authorizeHttpRequests( customizer ->
                        customizer.anyRequest().authenticated() )
                .formLogin( Customizer.withDefaults() )
//                .httpBasic( Customizer.withDefaults() )
                .authenticationProvider( userService )
//                .formLogin( customizer -> {
//                    customizer.loginPage( "/login.html" );
//                    customizer.successForwardUrl( "/limits.html" );
//                } )
        ;

        return httpSecurity.build();
    }


    @Bean
    public PasswordEncoder configurePasswordEncoder() {
        PasswordEncoder passEncoder = NoOpPasswordEncoder.getInstance();
        return passEncoder;
    }
}
