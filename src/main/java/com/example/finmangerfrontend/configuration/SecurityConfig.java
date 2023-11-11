package com.example.finmangerfrontend.configuration;

import com.example.finmangerfrontend.service.ApplicationUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
//    private final PasswordEncoder passwordEncoder;
//    private final ApplicationUserService applicationUserService;
//
//    public SecurityConfig( PasswordEncoder passwordEncoder, ApplicationUserService applicationUserService ) {
//        this.passwordEncoder = passwordEncoder;
//        this.applicationUserService = applicationUserService;
//    }

    @Bean
    public SecurityFilterChain configureChain( HttpSecurity httpSecurity ) throws Exception {
        httpSecurity
                .csrf( customizer -> customizer.disable() )
//                .headers( customizer -> customizer.disable() )
                .authorizeHttpRequests( customizer -> {
                    customizer.requestMatchers( "/" ).permitAll();
                    customizer.anyRequest().permitAll();
                } )
                .formLogin( form -> form.loginPage( "/login" ).permitAll() )
//                .authenticationProvider( authenticationProvider() )
        ;

        return httpSecurity.build();
    }

//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//
//        provider.setPasswordEncoder( passwordEncoder ); // allows to encode passwords
//        provider.setUserDetailsService( applicationUserService );
//
//        return provider;
//    }

}
